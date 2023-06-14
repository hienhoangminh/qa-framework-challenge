package com.rocktester.automation.qaframework.core.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

@Lazy
@Autowired
@Documented                           // when you want to generate Javadocs.
@Target({ElementType.FIELD})
// where do we plan to use this annotation. Since we use it on a class, its type is TYPE
@Retention(RetentionPolicy.RUNTIME)   // when is this annotation available? Runtime, etc...
public @interface LazyAutowired {
}
