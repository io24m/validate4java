package com.github.io24m.validate4java.validate;


import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.validate.annotation.Empty;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:43
 */
public class EmptyValidate implements BaseValidate {
    @Override
    public boolean filter(Object annotation) {
        return annotation instanceof Empty;
    }

    @Override
    public boolean check(Object value, Object annotation, ValidateMetadata metadata) {
        return value != null;
    }

    @Override
    public String errorMessage(Object value, Object annotation, ValidateMetadata metadata) {
        Empty empty = (Empty) annotation;
        return empty.errorMessage();
    }
}
