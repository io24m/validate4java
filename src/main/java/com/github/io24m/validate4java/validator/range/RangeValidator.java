package com.github.io24m.validate4java.validator.range;

import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.validator.AbstractValidator;

/**
 * @author lk1
 * @description
 * @create 2021-02-05 17:13
 */
public class RangeValidator extends AbstractValidator<Range> {
    @Override
    public boolean check(Object value, ValidateMetadata<Range> metadata) {
        if (value == null) {
            return true;
        }
        Range annotation = metadata.getAnnotation();
        String s = value.toString();
        int length = s.length();
        if (annotation.minLength() != -1 && length < annotation.minLength()) {
            return false;
        }
        if (annotation.maxLength() != -1 && length > annotation.maxLength()) {
            return false;
        }
        return true;
    }

    @Override
    public String errorMessage(ValidateMetadata<Range> metadata) {
        return metadata.getAnnotation().errorMessage();
    }
}
