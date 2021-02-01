package com.github.io24m.validate4java.validate;

import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.ValidateInfo;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:40
 */
public interface BaseValidate {
    boolean filter(Object an);

    ValidateInfo check(Object value, Object annotation, ValidateMetadata metadata);
}
