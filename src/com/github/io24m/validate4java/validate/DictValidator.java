package com.github.io24m.validate4java.validate;

import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.validate.annotation.Dict;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 16:36
 */
public class DictValidator extends AbstractValidator {
    @Override
    public boolean filter(Object annotation) {
        return annotation instanceof Dict;
    }

    @Override
    public boolean check(Object value, Object annotation, ValidateMetadata metadata) {

        return false;
    }

    @Override
    public String errorMessage(Object value, Object annotation, ValidateMetadata metadata) {
        Dict dict = (Dict) annotation;
        return dict.errorMessage();
    }
}
