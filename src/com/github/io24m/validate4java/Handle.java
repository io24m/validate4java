package com.github.io24m.validate4java;

import com.github.io24m.validate4java.validate.BaseValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:22
 */

public class Handle {
    private List<BaseValidator> validates = new ArrayList<>();

    public void config(BaseValidator... handles) {
        validates.addAll(Arrays.asList(handles));
    }

    public ValidateResult handle(Object value) {
        ValidateResult result = new ValidateResult();
        List<ValidateInfo> res = new ArrayList<>();
        List<ValidateMetadata> validateMetadata = validateMetadata(value);
        for (ValidateMetadata m : validateMetadata) {
            ValidateInfo info = new ValidateInfo();
            BaseValidator baseValidate = m.getBaseValidate();
            boolean success = baseValidate.check(m.getValue(), m.getAnnotation(), m);
            if (success) {
                continue;
            }
            boolean pass = baseValidate.pass(m.getAnnotation());
            info.setSuccess(pass);
            String errorMessage = baseValidate.errorMessage(m.getValue(), m.getAnnotation(), m);
            info.setErrorMessage(errorMessage);
            info.setType(m.getType());
            info.setFileName(m.getFileName());
            res.add(info);
        }
        Class<?> clazz = value.getClass();
        result.setValidateInfos(res);
        result.setType(clazz.getTypeName());
        result.setName(clazz.getSimpleName());
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
                    boolean check = v.filter(a);
                    if (check) {
                        ValidateMetadata validateMetadata = new ValidateMetadata();
                        validateMetadata.setFileName(name);
                        validateMetadata.setValue(fieldValue);
                        validateMetadata.setAnnotation(a);
                        validateMetadata.setBaseValidate(v);
                        validateMetadata.setType(field.getType());
                        res.add(validateMetadata);
                    }
                }
            }
        }
        return res;
    }
}
