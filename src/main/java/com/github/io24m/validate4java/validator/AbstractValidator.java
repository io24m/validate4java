package com.github.io24m.validate4java.validator;

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
}
