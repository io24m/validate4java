package com.github.io24m.validate4java.validate;

/**
 * @author lk1
 * @description
 * @create 2021-02-01 13:25
 */
public abstract class AbstractValidate implements BaseValidate {
    @Override
    public boolean pass(Object annotation) {
        return false;
    }
}
