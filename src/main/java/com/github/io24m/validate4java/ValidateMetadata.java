package com.github.io24m.validate4java;


import com.github.io24m.validate4java.validator.BaseValidator;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 15:04
 */
public class ValidateMetadata {
    private Class type;
    private String fileName;
    private Object value;
    private Object annotation;
    private BaseValidator baseValidate;

    public Class getType() {
        return type;
    }

    public void setType(Class type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Object annotation) {
        this.annotation = annotation;
    }

    public BaseValidator getBaseValidate() {
        return baseValidate;
    }

    public void setBaseValidate(BaseValidator baseValidate) {
        this.baseValidate = baseValidate;
    }
}
