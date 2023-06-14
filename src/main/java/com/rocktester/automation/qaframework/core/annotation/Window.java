package com.rocktester.automation.qaframework.core.annotation;

import java.lang.annotation.*;

@Page
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Window {
    int value() default 0;
}
