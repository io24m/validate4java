package com.github.io24m.validate4java.validate;

import com.github.io24m.validate4java.ValidateMetadata;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:40
 */
public interface BaseValidate {
    boolean filter(Object annotation);

    boolean pass(Object annotation);

    boolean check(Object value, Object annotation, ValidateMetadata metadata);

    String errorMessage(Object value, Object annotation, ValidateMetadata metadata);
}
