package com.rocktester.automation.qaframework.page;

import com.rocktester.automation.qaframework.core.annotation.Page;
import com.rocktester.automation.qaframework.core.annotation.Window;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

@Page
@Window(1)
@Slf4j
public class OrderDetailsPage extends Base {

    @FindBy(xpath = "//button[descendant::text()='Print Airway Bill']")
    private WebElement printAirwayBill;

    @FindBy(css = "div[testid='tracking-id']")
    private WebElement trackingId;

    @FindBy(xpath = "//div[@class='ant-modal-body']//div[@data-analyticsid='selectAWBLayout' and descendant::text()='1 bills per page']")
    private WebElement printAirwayBillFirstOption;

    @FindBy(xpath = "//a[descendant::span[@data-key='print']]")
    private WebElement printButton;

    public void isTrackingIdValid(String id) {
        log.info("Is tracking valid?");
        assertThat(this.trackingId.getText()).isEqualTo(id);
    }

    public OrderDetailsPage clickOnOneBillsPerPage() {
        log.info("Click on 1 bills per page option");
        this.wait.until(d -> this.printAirwayBillFirstOption.isDisplayed());
        this.printAirwayBillFirstOption.click();
        return this;
    }

    public OrderDetailsPage clickOnPrintAirwayButton() {
        log.info("Click on Print Airway button");
        this.wait.until(d -> this.printAirwayBill.isDisplayed());
        this.printAirwayBill.click();
        return this;
    }

    public void clickOnPrintButton() {
        log.info("Click on Print button");
        this.wait.until(ExpectedConditions.elementToBeClickable(this.printButton));
        this.printButton.click();
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.trackingId.isDisplayed());
    }
}
