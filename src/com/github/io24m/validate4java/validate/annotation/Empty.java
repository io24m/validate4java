package com.github.io24m.validate4java.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:25
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Empty {
    boolean pass() default false;

    String configKey() default "";

    String errorMessage() default "";
}
