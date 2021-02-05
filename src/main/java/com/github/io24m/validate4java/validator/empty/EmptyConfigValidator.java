package com.github.io24m.validate4java.validator.empty;

import com.github.io24m.validate4java.ValidateMetadata;

import java.util.Map;

/**
 * @author lk1
 * @description
 * @create 2021-02-01 10:39
 */
public class EmptyConfigValidator extends EmptyValidator {
    private Map<String, EmptyConfig> cfg;

    public EmptyConfigValidator(Map<String, EmptyConfig> config) {
        this.cfg = config;
    }

    @Override
    public boolean filter(Empty annotation) {
        EmptyConfig config = this.cfg.get(annotation.configKey());
        if (config == null) {
            return super.filter(annotation);
        }
        return config.isCheck();
    }

    @Override
    public boolean pass(Empty annotation) {
        EmptyConfig config = this.cfg.get(annotation.configKey());
        if (config == null) {
            return super.pass(annotation);
        }
        return config.isPass();
    }

    @Override
    public String errorMessage(Object value, Empty annotation, ValidateMetadata metadata) {
        EmptyConfig config = this.cfg.get(annotation.configKey());
        if (config == null) {
            return super.errorMessage(value, annotation, metadata);
        }
        return config.getErrorMessage();
    }

}
