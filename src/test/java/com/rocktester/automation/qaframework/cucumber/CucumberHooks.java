package com.rocktester.automation.qaframework.cucumber;

import com.rocktester.automation.qaframework.core.annotation.LazyAutowired;
import com.rocktester.automation.qaframework.core.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import java.util.Calendar;

public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext ctx;

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.attach(this.screenshotService.getScreenshot(), "image/png", scenario.getName() + "_" + Calendar.getInstance().getTimeInMillis());
        }
    }

    @After
    public void afterScenario() {
        this.ctx.getBean(WebDriver.class).quit();
    }
}
