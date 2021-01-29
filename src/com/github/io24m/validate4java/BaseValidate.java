package com.github.io24m.validate4java;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:40
 */
public interface BaseValidate {
    boolean check(Object an, ValidateConfig config);

    ValidateResult check(Object value, Object annotation, ValidateConfig config, ValidateMetadata metadata);
}
