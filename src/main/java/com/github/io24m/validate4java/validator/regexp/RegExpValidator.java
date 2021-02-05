package com.github.io24m.validate4java.validator.regexp;

import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.validator.AbstractValidator;

import java.util.regex.Pattern;

/**
 * @author lk1
 * @description
 * @create 2021-02-05 17:27
 */
public class RegExpValidator extends AbstractValidator<RegExp> {
    @Override
    public boolean check(Object value, RegExp annotation, ValidateMetadata metadata) {
        if (value == null) {
            return true;
        }
        return Pattern.matches(annotation.regExp(), value.toString());
    }

    @Override
    public String errorMessage(Object value, RegExp annotation, ValidateMetadata metadata) {
        return annotation.errorMessage();
    }
}
