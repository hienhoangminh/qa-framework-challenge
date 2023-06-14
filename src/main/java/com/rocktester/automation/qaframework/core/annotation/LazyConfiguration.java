package com.rocktester.automation.qaframework.core.annotation;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.lang.annotation.*;

@Lazy
@Configuration
@Documented                           // when you want to generate Javadocs.
@Target({ElementType.TYPE})
// where do we plan to use this annotation. Since we use it on a class, its type is TYPE
@Retention(RetentionPolicy.RUNTIME)   // when is this annotation available? Runtime, etc...
public @interface LazyConfiguration {
}
