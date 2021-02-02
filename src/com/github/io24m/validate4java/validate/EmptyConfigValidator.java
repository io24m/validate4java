package com.github.io24m.validate4java.validate;

import com.github.io24m.validate4java.validate.annotation.Empty;

import java.util.Map;

/**
 * @author lk1
 * @description
 * @create 2021-02-01 10:39
 */
public class EmptyConfigValidator extends EmptyValidator {
    private Map<String, Boolean> config;

    public EmptyConfigValidator(Map<String, Boolean> config) {
        this.config = config;
    }

    @Override
    public boolean filter(Object annotation) {
        boolean filter = annotation instanceof Empty;
        if (!filter) {
            return false;
        }
        Empty empty = (Empty) annotation;
        Boolean config = this.config.get(empty.configKey());
        return config == null || config;
    }

    @Override
    public boolean pass(Object annotation) {
        Empty empty = (Empty) annotation;
        return empty.pass();
    }
}