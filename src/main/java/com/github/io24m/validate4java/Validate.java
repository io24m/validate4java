package com.github.io24m.validate4java;

import com.github.io24m.validate4java.validator.BaseValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:22
 */

public class Validate {
    private List<BaseValidator> validates = new ArrayList<>();

    public void config(BaseValidator... handles) {
        validates.addAll(Arrays.asList(handles));
    }

    public ValidateResult handle(Object... values) {
        ValidateResult result = new ValidateResult();
        for (Object obj : values) {
            result.merge(handle(obj));
        }
        return result;
    }

    public ValidateResult handle(Object value) {
        ValidateResult result = new ValidateResult();
        List<ValidateInfo> res = new ArrayList<>();
        List<ValidateMetadata> validateMetadata = validateMetadata(value);
        for (ValidateMetadata m : validateMetadata) {
            ValidateInfo info = new ValidateInfo();
            BaseValidator baseValidate = m.getBaseValidate();
            boolean success = baseValidate.check(m.getValue(), m);
            if (success) {
                continue;
            }
            boolean pass = baseValidate.pass(m);
            info.setSuccess(pass);
            String errorMessage = baseValidate.errorMessage(m);
            info.setErrorMessage(errorMessage);
            info.setType(m.getType());
            info.setFileName(m.getFileName());
            res.add(info);
        }
        result.setValidateInfos(res);
        return result;
    }

    private List<ValidateMetadata> validateMetadata(Object value) {
        List<ValidateMetadata> res = new ArrayList<>();
        Class<?> clazz = value.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object fieldValue;
            try {
                fieldValue = field.get(value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            Annotation[] annotations = field.getAnnotations();
            for (BaseValidator v : validates) {
                for (Annotation a : annotations) {
                    Class annotationType = getTType(v.getClass());
                    boolean equals = annotationType.equals(a.annotationType());
                    if (!equals) {
                        continue;
                    }

                    ValidateMetadata validateMetadata = new ValidateMetadata();
                    validateMetadata.setFileName(name);
                    validateMetadata.setValue(fieldValue);
                    validateMetadata.setAnnotation(a);
                    validateMetadata.setBaseValidate(v);
                    validateMetadata.setType(field.getType());
                    boolean filter = v.filter(validateMetadata);
                    if (!filter) {
                        continue;
                    }
                    res.add(validateMetadata);

                }
            }
        }
        return res;
    }

    private Class getTType(Class clazz) {
        if (clazz == null) {
            return null;
        }
        Type genericSuperclass = clazz.getGenericSuperclass();
        if (genericSuperclass instanceof ParameterizedType) {
            Type actualTypeArgument = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
            return (Class) actualTypeArgument;
        }
        Class superclass = clazz.getSuperclass();
        if (superclass == null) {
            return null;
        }
        return getTType(superclass);
    }
}
