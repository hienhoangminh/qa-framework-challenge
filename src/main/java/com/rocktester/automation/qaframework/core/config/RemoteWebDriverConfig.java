package com.rocktester.automation.qaframework.core.config;

import com.rocktester.automation.qaframework.core.annotation.LazyConfiguration;
import com.rocktester.automation.qaframework.core.annotation.ThreadScopeBean;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Profile;

import java.net.URL;

@LazyConfiguration
@Profile("remote") //basically this configuration is enabled when Spring profile is equal to "remote"
public class RemoteWebDriverConfig {

    @Value("${selenium.grid.url}")
    private URL url;

    @Value("${default.timeout:30}")
    private int timeout;

    @ThreadScopeBean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver remoteFirefoxDriver() {
        return new RemoteWebDriver(this.url, new FirefoxOptions());
    }

    @ThreadScopeBean
    @ConditionalOnMissingBean
    public WebDriver remoteChromeDriver() {
        return new RemoteWebDriver(this.url, new ChromeOptions());
    }

}
