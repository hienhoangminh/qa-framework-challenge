package com.rocktester.automation.qaframework.page;

import com.rocktester.automation.qaframework.core.annotation.LazyAutowired;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class Base {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @LazyAutowired
    protected JavascriptExecutor js;

    //Lifecycle method
    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAt();
}
