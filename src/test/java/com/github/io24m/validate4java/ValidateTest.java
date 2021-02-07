package com.github.io24m.validate4java;

import com.github.io24m.validate4java.validator.dict.Dict;
import com.github.io24m.validate4java.validator.dict.DictConfigValidator;
import com.github.io24m.validate4java.validator.empty.Empty;
import com.github.io24m.validate4java.validator.empty.EmptyConfigValidator;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author lk1
 * @description
 * @create 2021-02-07 10:07
 */
public class ValidateTest {
    @Test
    public void test() {
        Validate validate = new Validate();
        validate.config(new EmptyConfigValidator(new HashMap<>()));
        validate.config(new DictConfigValidator(null, new HashMap<>()));
        ValidateResult result = validate.handle(new Person(),new Person());
        System.out.println(result.getErrorMessage());
        System.out.println(result.getMessage());
    }

    public class Person {
        @Empty(errorMessage = "name:error")
        private String name;
        @Dict(errorMessage = "age:error")
        private Integer age;
    }
}
