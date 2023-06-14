package com.rocktester.automation.qaframework.page;

import com.rocktester.automation.qaframework.core.annotation.Page;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Objects;

@Page
@Slf4j
public class LandingPage extends Base {

    @FindBy(css = "ul[data-onboarding='left_nav'] li[data-analyticsid='tracking']")
    private WebElement trackingMenu;

    @FindBy(xpath = "//button[descendant::text()='Got it!']")
    private WebElement gotItButton;

    @FindBy(css = "div.rcw-widget-container button.rcw-hide-sm")
    private WebElement minimizeChatWidgetButton;

    public void clickOnTrackingMenu() {
        log.info("Click on Tracking menu");
        this.wait.until(d -> this.trackingMenu.isEnabled());
        this.trackingMenu.click();
    }

    public LandingPage clickOnGotItButtonIfNeeds() {
        log.info("Click on got it button if needs");
        WebElement element = this.wait.until(ExpectedConditions.visibilityOf(this.gotItButton));
        if (Objects.nonNull(element)) {
            element.click();
        }
        return this;
    }

    public LandingPage minimizeChatWidget() {
        log.info("Minimize chat widget by clicking on X button");
        WebElement element = this.wait.until(ExpectedConditions.visibilityOf(this.minimizeChatWidgetButton));
        if (Objects.nonNull(element)) {
            element.click();
        }
        return this;
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.trackingMenu.isDisplayed());
    }


}
