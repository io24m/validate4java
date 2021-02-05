package com.github.io24m.validate4java.validator.dict;

import com.github.io24m.validate4java.ValidateMetadata;

import java.util.Map;
import java.util.Set;

/**
 * @author lk1
 * @description
 * @create 2021-02-05 13:21
 */
public class DictConfigValidator extends DictValidator {
    private Map<String, DictConfig> config;

    public DictConfigValidator(Map<String, Set<String>> dict, Map<String, DictConfig> config) {
        super(dict);
        this.config = config;
    }

    @Override
    public boolean filter(Dict annotation) {
        DictConfig dictConfig = config.get(annotation.configKey());
        if (dictConfig == null)
            return super.filter(annotation);
        return dictConfig.isCheck();
    }

    @Override
    public String errorMessage(Object value, Dict annotation, ValidateMetadata metadata) {
        DictConfig dictConfig = config.get(annotation.configKey());
        if (dictConfig == null)
            return super.errorMessage(value, annotation, metadata);
        return dictConfig.getErrorMessage();

    }

    @Override
    public boolean pass(Dict annotation) {
        DictConfig dictConfig = config.get(annotation.configKey());
        if (dictConfig == null)
            return super.pass(annotation);
        return dictConfig.isPass();
    }
}
