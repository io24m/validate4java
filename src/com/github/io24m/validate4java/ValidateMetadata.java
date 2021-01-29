package com.github.io24m.validate4java;


/**
 * @author lk1
 * @description
 * @create 2021-01-29 15:04
 */
public class ValidateMetadata {
    private String name;
    private Object value;
    private Object annotation;
    private BaseValidate baseValidate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public BaseValidate getBaseValidate() {
        return baseValidate;
    }

    public void setBaseValidate(BaseValidate baseValidate) {
        this.baseValidate = baseValidate;
    }
}
