package com.github.io24m.validate4java.validate;


import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.ValidateResult;
import com.github.io24m.validate4java.validate.annotation.Empty;
import com.github.io24m.validate4java.validate.config.ValidateConfig;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:43
 */
public class EmptyValidate implements BaseValidate {
    @Override
    public boolean filter(Object an, ValidateConfig config) {
        return an instanceof Empty;
    }

    @Override
    public ValidateResult check(Object value, Object annotation, ValidateConfig config, ValidateMetadata metadata) {
        Empty empty = (Empty) annotation;
        Object cfg = config.get(empty.configKey());

        if (value == null) {
            ValidateResult res = new ValidateResult();
            res.setSuccess(false);
            res.setErrorMessage(metadata.getName() + ":not empty.");
            return res;
        }
        return ValidateResult.success();
    }
}
