package com.rocktester.automation.qaframework.cucumber;

import io.cucumber.junit.platform.engine.Constants;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectDirectories;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectDirectories("src/test/java/com/rocktester/automation/qaframework/cucumber/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.rocktester.automation.qaframework.cucumber")
@ConfigurationParameter(key = Constants.PLUGIN_PUBLISH_QUIET_PROPERTY_NAME, value = "true")
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "html:target/cucumber-reports.html")
public class CucumberRunner{

}