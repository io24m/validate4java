package com.github.io24m.validate4java.validator;

/**
 * @author lk1
 * @description
 * @create 2021-02-05 13:32
 */
public class ValidatorConfig {
    private boolean check;
    private boolean pass;
    private String errorMessage;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
