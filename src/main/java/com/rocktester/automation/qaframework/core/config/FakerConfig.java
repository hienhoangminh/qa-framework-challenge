package com.rocktester.automation.qaframework.core.config;

import com.github.javafaker.Faker;
import com.rocktester.automation.qaframework.core.annotation.LazyConfiguration;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker() {
        return new Faker();
    }
}
