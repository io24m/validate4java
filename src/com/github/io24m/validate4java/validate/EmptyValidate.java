package com.github.io24m.validate4java.validate;


import com.github.io24m.validate4java.ValidateConfig;
import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.ValidateResult;
import com.github.io24m.validate4java.validate.annotation.Empty;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:43
 */
public class EmptyValidate implements BaseValidate {
    @Override
    public boolean check(Object an, ValidateConfig config) {
        return an instanceof Empty;
    }

    @Override
    public ValidateResult check(Object value, Object annotation, ValidateConfig config, ValidateMetadata metadata) {
        ValidateResult res = new ValidateResult();
        if (value == null) {
            res.setSuccess(false);
            res.setErrorMessage(metadata.getName() + "：不能为空");
            return res;
        }
        Empty empty = (Empty) annotation;
        res.setSuccess(true);
        return res;
    }
}
