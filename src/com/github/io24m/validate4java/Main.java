package com.github.io24m.validate4java;

import com.github.io24m.validate4java.validate.DictValidate;
import com.github.io24m.validate4java.validate.EmptyConfigValidate;
import com.github.io24m.validate4java.validate.annotation.Dict;
import com.github.io24m.validate4java.validate.annotation.Empty;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Dto medical = new Dto();
        medical.setAge(20);

        Handle handle = new Handle();
        Map<String, Boolean> cfg = new HashMap<>();
        cfg.put("name", true);
        cfg.put("sex", false);
        handle.config(new EmptyConfigValidate(cfg), new DictValidate());

        handle.handle(medical);
    }

    public static class Dto {
        @Empty(configKey = "name", errorMessage = "姓名不能为空")
        private String name;

        @Empty(configKey = "sex", errorMessage = "性别不能为空")
        private String sex;

        @Dict
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
