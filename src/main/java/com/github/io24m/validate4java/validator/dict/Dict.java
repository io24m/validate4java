package com.github.io24m.validate4java.validator.dict;

import java.lang.annotation.*;

/**
 * @author lk1
 * @description
 * @create 2021-01-29 14:26
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Dict {
    String dictKey() default "";

    boolean pass() default false;

    String errorMessage() default "dictionary error";
}
