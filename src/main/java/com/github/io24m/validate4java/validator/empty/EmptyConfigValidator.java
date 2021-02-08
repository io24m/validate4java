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
    public boolean filter(ValidateMetadata<Empty> metadata) {
        EmptyConfig config = this.cfg.get(metadata.key());
        if (config == null) {
            return super.filter(metadata);
        }
        return config.isCheck();
    }

    @Override
    public boolean pass(ValidateMetadata<Empty> metadata) {
        EmptyConfig config = this.cfg.get(metadata.key());
        if (config == null) {
            return super.pass(metadata);
        }
        return config.isPass();
    }

    @Override
    public String errorMessage(ValidateMetadata<Empty> metadata) {
        EmptyConfig config = this.cfg.get(metadata.key());
        if (config == null) {
            return super.errorMessage(metadata);
        }
        return config.getErrorMessage();
    }

}
