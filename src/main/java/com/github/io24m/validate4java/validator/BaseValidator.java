package com.github.io24m.validate4java.validator;

import com.github.io24m.validate4java.ValidateMetadata;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:40
 */
public interface BaseValidator<T> {
    boolean filter(ValidateMetadata<T> metadata);

    boolean pass(ValidateMetadata<T> metadata);

    boolean check(Object value, ValidateMetadata<T> metadata);

    String errorMessage(ValidateMetadata<T> metadata);
}
