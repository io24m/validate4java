package com.github.io24m.validate4java;

import java.util.List;

/**
 * @author lk1
 * @description
 * @create 2021-02-01 10:53
 */
public class ValidateResult {
    private String type;
    private String name;
    private List<ValidateInfo> validateInfos;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ValidateInfo> getValidateInfos() {
        return validateInfos;
    }

    public void setValidateInfos(List<ValidateInfo> validateInfos) {
        this.validateInfos = validateInfos;
    }
}
