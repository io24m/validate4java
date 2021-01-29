package com.github.io24m.validate4java.validate;

import com.github.io24m.validate4java.validate.config.ValidateConfig;
import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.ValidateResult;
import com.github.io24m.validate4java.validate.annotation.Dict;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 16:36
 */
public class DictValidate implements BaseValidate {
    @Override
    public boolean filter(Object an, ValidateConfig config) {
        return an instanceof Dict;
    }

    @Override
    public ValidateResult check(Object value, Object annotation, ValidateConfig config, ValidateMetadata metadata) {

        return ValidateResult.success();
    }
}
