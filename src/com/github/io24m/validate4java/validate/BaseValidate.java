package com.github.io24m.validate4java.validate;

import com.github.io24m.validate4java.ValidateConfig;
import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.ValidateResult;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:40
 */
public interface BaseValidate {
    boolean filter(Object an, ValidateConfig config);

    ValidateResult check(Object value, Object annotation, ValidateConfig config, ValidateMetadata metadata);
}
