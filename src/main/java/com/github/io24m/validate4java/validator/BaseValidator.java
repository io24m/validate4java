package com.github.io24m.validate4java.validator;

import com.github.io24m.validate4java.ValidateMetadata;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:40
 */
public interface BaseValidator<T> {
    boolean filter(T annotation);

    boolean pass(T annotation);

    boolean check(Object value, T annotation, ValidateMetadata metadata);

    String errorMessage(Object value, T annotation, ValidateMetadata metadata);
}
