package com.rocktester.automation.qaframework.core.exception;

public class AutomationException extends Exception {
    public AutomationException(String exception) {
        super(exception);
    }

    public AutomationException(String exception, String... arguments) {
        super(String.format(exception, arguments));
    }
}
