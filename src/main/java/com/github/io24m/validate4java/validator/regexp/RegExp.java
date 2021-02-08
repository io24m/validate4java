package com.github.io24m.validate4java.validator.regexp;

import java.lang.annotation.*;

/**
 * @author lk1
 * @description
 * @create 2021-02-05 17:26
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RegExp {
    String regExp() default "";

    String errorMessage() default "regular expression error";
}
