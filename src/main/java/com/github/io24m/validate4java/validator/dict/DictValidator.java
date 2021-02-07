package com.github.io24m.validate4java.validator.dict;

import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.validator.AbstractValidator;

import java.util.Map;
import java.util.Set;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 16:36
 */
public class DictValidator extends AbstractValidator<Dict> {
    private Map<String, Set<String>> dictMap;

    public DictValidator(Map<String, Set<String>> dict) {
        this.dictMap = dict;
    }

    @Override
    public boolean check(Object value, Dict annotation, ValidateMetadata metadata) {
        if (value == null) {
            return true;
        }
        if (dictMap == null) {
            return false;
        }
        Set<String> keys = dictMap.get(annotation.dictKey());
        if (keys == null) {
            return false;
        }
        return keys.contains(value.toString());
    }

    @Override
    public String errorMessage(Object value, Dict annotation, ValidateMetadata metadata) {
        return annotation.errorMessage();
    }
}
