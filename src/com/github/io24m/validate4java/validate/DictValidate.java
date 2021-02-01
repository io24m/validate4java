package com.github.io24m.validate4java.validate;

import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.ValidateInfo;
import com.github.io24m.validate4java.validate.annotation.Dict;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 16:36
 */
public class DictValidate implements BaseValidate {
    @Override
    public boolean filter(Object an) {
        return an instanceof Dict;
    }

    @Override
    public ValidateInfo check(Object value, Object annotation, ValidateMetadata metadata) {

        return ValidateInfo.success();
    }
}
