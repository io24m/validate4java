package com.github.io24m.validate4java;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author lk1
 * @description
 * @create 2021-02-01 10:53
 */
public class ValidateResult {
    private String type;
    private String name;
    private List<ValidateInfo> validateInfos = new ArrayList<>();

    public boolean success() {
        if (validateInfos == null || validateInfos.size() == 0) {
            return true;
        }
        return validateInfos.stream().anyMatch(ValidateInfo::isSuccess);
    }

    public List<String> getErrorMessage(Function<ValidateInfo, Boolean> filter) {
        List<String> errorMessage = validateInfos.stream()
                .filter(filter::apply)
                .map(ValidateInfo::getErrorMessage)
                .collect(Collectors.toList());
        return errorMessage;
    }

    public List<String> getErrorMessage() {
        return getErrorMessage(x -> !x.isSuccess());
    }

    public List<String> getMessage() {
        return getErrorMessage(ValidateInfo::isSuccess);
    }

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
