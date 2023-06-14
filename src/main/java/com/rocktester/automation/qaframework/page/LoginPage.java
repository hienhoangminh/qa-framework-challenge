package com.rocktester.automation.qaframework.page;

import com.rocktester.automation.qaframework.core.annotation.Page;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

@Page
@Slf4j
public class LoginPage extends Base {

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    @FindBy(linkText = "Sign up here!")
    private WebElement signUpLink;

    @Value("${baseUrl}")
    private String baseUrl;

    public void goTo() {
        this.driver.get(this.baseUrl);
        this.driver.manage().window().maximize();
    }

    public LoginPage enterEmailInput(String email) {
        log.info("Enter email {} into email input", email);
        this.emailInput.sendKeys(email);
        return this;
    }

    public LoginPage enterPasswordInput(String password) {
        log.info("Enter password {} into password input", password);
        this.passwordInput.sendKeys(password);
        return this;
    }

    public void clickOnLoginButton() {
        log.info("Click on Login button");
        this.wait.until(d -> this.loginButton.isEnabled());
        this.loginButton.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.signUpLink.isDisplayed());
    }
}
