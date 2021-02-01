package com.github.io24m.validate4java;

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
    private List<ValidateInfo> validateInfos;

    public List<String> getErrorMessage(Function<ValidateInfo, String> func) {
        List<String> errorMessage = validateInfos.stream()
                .filter(x -> !x.isSuccess())
                .map(x -> {
                    if (func == null) {
                        return x.getErrorMessage();
                    } else {
                        return func.apply(x);
                    }
                })
                .collect(Collectors.toList());
        return errorMessage;
    }

    public List<String> getErrorMessage() {
        return getErrorMessage(null);
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
