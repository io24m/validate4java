package com.github.io24m.validate4java.validator.empty;


import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.validator.AbstractValidator;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:43
 */
public class EmptyValidator extends AbstractValidator<Empty> {
    @Override
    public boolean check(Object value, Empty annotation, ValidateMetadata metadata) {
        return value != null && !value.toString().equals("");
    }

    @Override
    public String errorMessage(Object value, Empty annotation, ValidateMetadata metadata) {
        return annotation.errorMessage();
    }
}
