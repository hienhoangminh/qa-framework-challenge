package com.rocktester.automation.qaframework.core.aop;

import com.rocktester.automation.qaframework.core.annotation.Window;
import com.rocktester.automation.qaframework.core.service.WindowSwitchService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowSwitchService switchService;

    @Before("@target(window) && within(com.rocktester.automation.qaframework..*)")
    //Take class which has annotation called Window and this class is presented in this
    // package com.testing.spring.springselenium
    // before execution of each method, run this
    public void before(Window window) {
        this.switchService.switchByIndex(window.value());
    }

    //This will be execute after each method execution
    public void after(Window window) {
        this.switchService.switchByIndex(0);
    }

}


