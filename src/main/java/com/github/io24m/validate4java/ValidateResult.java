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
    private List<ValidateInfo> validateInfos = new ArrayList<>();

    public ValidateResult merge(ValidateResult validateResult) {
        validateInfos.addAll(validateResult.getValidateInfos());
        return this;
    }

    public boolean success() {
        if (validateInfos == null || validateInfos.size() == 0) {
            return true;
        }
        return validateInfos.stream().anyMatch(ValidateInfo::isSuccess);
    }

    public List<String> getMessage(Function<ValidateInfo, Boolean> filter) {
        List<String> errorMessage = validateInfos.stream()
                .filter(filter::apply)
                .map(ValidateInfo::getErrorMessage)
                .collect(Collectors.toList());
        return errorMessage;
    }

    public List<String> getErrorMessage() {
        return getMessage(x -> !x.isSuccess());
    }

    public List<String> getMessage() {
        return getMessage(ValidateInfo::isSuccess);
    }

    public List<ValidateInfo> getValidateInfos() {
        return validateInfos;
    }

    public void setValidateInfos(List<ValidateInfo> validateInfos) {
        this.validateInfos = validateInfos;
    }
}
