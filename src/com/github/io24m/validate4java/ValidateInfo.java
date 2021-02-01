package com.github.io24m.validate4java;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:53
 */

public class ValidateInfo {
    private String fileName;
    private Class type;
    private boolean success;
    private String format;
    private String errorMessage;
    private List<Object> metadata;

    public static ValidateInfo success() {
        ValidateInfo validateResult = new ValidateInfo();
        validateResult.success = true;
        return validateResult;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

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
}
