package com.github.io24m.validate4java.validator.empty;

import java.lang.annotation.*;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:25
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Empty {
    boolean pass() default false;

    String configKey() default "";

    String errorMessage() default "empty error";
}
