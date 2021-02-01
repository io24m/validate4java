package com.github.io24m.validate4java.validate;


import com.github.io24m.validate4java.ValidateInfo;
import com.github.io24m.validate4java.ValidateMetadata;
import com.github.io24m.validate4java.validate.annotation.Empty;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:43
 */
public class EmptyValidate implements BaseValidate {
    @Override
    public boolean filter(Object annotation) {
        return annotation instanceof Empty;
    }

    @Override
    public ValidateInfo check(Object value, Object annotation, ValidateMetadata metadata) {
        Empty empty = (Empty) annotation;
        if (value == null) {
            ValidateInfo res = new ValidateInfo();
            res.setSuccess(false);
            res.setErrorMessage(empty.errorMessage());
            return res;
        }
        return ValidateInfo.success();
    }
}
