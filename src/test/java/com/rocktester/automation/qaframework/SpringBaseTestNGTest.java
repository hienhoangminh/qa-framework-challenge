package com.rocktester.automation.qaframework;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@SpringBootTest
@CucumberContextConfiguration
public class SpringBaseTestNGTest extends AbstractTestNGSpringContextTests {
}
