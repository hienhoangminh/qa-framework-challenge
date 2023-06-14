package com.rocktester.automation.qaframework.core.config;

import com.rocktester.automation.qaframework.core.annotation.LazyConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

@LazyConfiguration
public class WebDriverWaitConfig {

    @Value("${default.timeout:45}")
    private int timeout;

    @Bean
    // default scope is Singleton.
    // We can define its scope as thread-scope and prototype
    // but thread-scope is tighly coupled with WebDriver instance
    // We also can not verify wether WebDriverWait is used or not.
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    // we want to have WebDriverWait instance for each created WebDriver instance.
    public WebDriverWait webDriverWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.of(this.timeout, ChronoUnit.SECONDS));
    }
}
