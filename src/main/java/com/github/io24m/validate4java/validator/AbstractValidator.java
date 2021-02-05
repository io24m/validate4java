package com.github.io24m.validate4java.validator;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author lk1
 * @description
 * @create 2021-02-01 13:25
 */
public abstract class AbstractValidator<T> implements BaseValidator<T> {
    @Override
    public boolean pass(T annotation) {
        return false;
    }

    @Override
    public boolean filter(T annotation) {
        return true;
    }

    @Override
    public Class getAnnotationType() {
        return getTType(getClass());
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
