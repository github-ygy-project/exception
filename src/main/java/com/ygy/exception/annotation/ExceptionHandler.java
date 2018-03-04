package com.ygy.exception.annotation;

import java.lang.annotation.*;

/**
 * Created by guoyao on 2018/2/25.
 * 标记异常处理器注解类
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface ExceptionHandler {

    String order() default "0" ;
}
