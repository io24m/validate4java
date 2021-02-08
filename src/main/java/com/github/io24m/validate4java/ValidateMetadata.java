package com.github.io24m.validate4java;


import com.github.io24m.validate4java.validator.BaseValidator;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 15:04
 */
public class ValidateMetadata<T> {
    private Class type;
    private String fileName;
    private Object value;
    private T annotation;
    private BaseValidator baseValidate;

    public String key() {
        return String.format("%s-%s", type.getName(), fileName);
    }

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

    public T getAnnotation() {
        return annotation;
    }

    public void setAnnotation(T annotation) {
        this.annotation = annotation;
    }

    public BaseValidator getBaseValidate() {
        return baseValidate;
    }

    public void setBaseValidate(BaseValidator baseValidate) {
        this.baseValidate = baseValidate;
    }
}
