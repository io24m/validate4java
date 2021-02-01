package com.github.io24m.validate4java;

import com.github.io24m.validate4java.validate.DictValidate;
import com.github.io24m.validate4java.validate.EmptyConfigValidate;
import com.github.io24m.validate4java.validate.annotation.Dict;
import com.github.io24m.validate4java.validate.annotation.Empty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Dto medical = new Dto();
        medical.setAge(20);

        Handle handle = new Handle();
        Map<String, Boolean> cfg = new HashMap<>();
        cfg.put("name", true);
        cfg.put("sex", true);
        handle.config(new EmptyConfigValidate(cfg), new DictValidate());

        ValidateResult result = handle.handle(medical);
        boolean success = result.success();
        System.out.println(success);
        List<String> errorMessage = result.getErrorMessage();
        System.out.println(errorMessage);
        List<String> message = result.getMessage();
        System.out.println(message);
    }

    public static class Dto {
        @Empty(configKey = "name", errorMessage = "name empty", pass = true)
        private String name;

        @Dict(errorMessage = "sex not in dict")
        @Empty(configKey = "sex", errorMessage = "sex empty")
        private String sex;

        @Dict(errorMessage = "age not in dict")
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
