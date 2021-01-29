package com.github.io24m.validate4java;

import com.github.io24m.validate4java.annotation.Dict;
import com.github.io24m.validate4java.annotation.Empty;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Dto medical = new Dto();
        medical.setAge(20);

        Handle handle = new Handle();
        handle.config(new EmptyValidate(), new EmptyValidate());
        handle.config(new ValidateConfig());

        List<ValidateResult> validateResults = handle.handle(medical, new ValidateConfig());
    }

    public static class Dto {
        @Empty(config = "fdsafsd")
        private String name;

        @Dict
        private Integer age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
