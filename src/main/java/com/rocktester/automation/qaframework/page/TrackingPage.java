package com.rocktester.automation.qaframework.page;

import com.google.common.util.concurrent.Uninterruptibles;
import com.rocktester.automation.qaframework.core.annotation.Page;
import com.rocktester.automation.qaframework.core.annotation.Window;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

@Page
@Slf4j
@Window(0)
public class TrackingPage extends Base {

    @FindBy(css = "button[data-analyticsid='order search']")
    private WebElement searchButton;

    @FindBy(css = ".ReactVirtualized__Table__Grid .ReactVirtualized__Table__row:nth-child(1) div:nth-child(2)")
    private WebElement firstTrackingIdNumber;

    public TrackingPage clickOnSearchButton() {
        log.info("Click on Search button");
        this.searchButton.click();
        return this;
    }

    public void clickOnFirstTrackingId() {
        log.info("Click on first tracking id");
        this.firstTrackingIdNumber.click();
    }

    public String getTrackingId() {
        log.info("Get tracking id");
        this.wait.until(d -> this.firstTrackingIdNumber.isDisplayed());
        return this.firstTrackingIdNumber.getText();
    }

    @Override
    public boolean isAt() {
        Uninterruptibles.sleepUninterruptibly(15, TimeUnit.SECONDS);
        return this.wait.until(d -> this.searchButton.isDisplayed());
    }


}
