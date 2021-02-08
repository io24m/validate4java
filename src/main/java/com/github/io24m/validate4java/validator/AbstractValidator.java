package com.github.io24m.validate4java.validator;

import com.github.io24m.validate4java.ValidateMetadata;

/**
 * @author lk1
 * @description
 * @create 2021-02-01 13:25
 */
public abstract class AbstractValidator<T> implements BaseValidator<T> {
    @Override
    public boolean pass(ValidateMetadata<T> metadata) {
        return false;
    }

    @Override
    public boolean filter(ValidateMetadata<T> metadata) {
        return true;
    }
}
