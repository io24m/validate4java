package com.github.io24m.validate4java.validator.range;

import java.lang.annotation.*;

/**
 * @author lk1
 * @description
 * @create 2021-02-05 17:12
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Range {
    int minLength() default -1;

    int maxLength() default -1;

    String errorMessage() default "range error";
}
