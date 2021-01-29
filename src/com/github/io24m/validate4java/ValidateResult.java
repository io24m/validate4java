package com.github.io24m.validate4java;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:53
 */

public class ValidateResult {
    private boolean success;
    private String format;
    private String errorMessage;
    private List<Object> metadata;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public List<Object> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<Object> metadata) {
        this.metadata = metadata;
    }

    public static ValidateResult success() {
        ValidateResult validateResult = new ValidateResult();
        validateResult.setSuccess(true);
        return validateResult;
    }
}
