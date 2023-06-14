package com.rocktester.automation.qaframework.tests;

import com.rocktester.automation.qaframework.SpringBaseTestNGTest;
import com.rocktester.automation.qaframework.core.exception.AutomationException;
import com.rocktester.automation.qaframework.core.service.WindowSwitchService;
import com.rocktester.automation.qaframework.page.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class NonBDDPrintAirwayBillTest extends SpringBaseTestNGTest {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private LandingPage landingPage;

    @Autowired
    private TrackingPage trackingPage;

    @Autowired
    private OrderDetailsPage orderDetailsPage;

    @Autowired
    private AirwayBillPage airwayBillPage;

    @Autowired
    private WindowSwitchService switchService;

    @Test
    public void checkDetail() throws AutomationException {
        this.loginPage.goTo();
        this.loginPage.isAt();
        this.loginPage.enterEmailInput("challenge2@ninjavan.co").enterPasswordInput("Ninjavan1234").clickOnLoginButton();
        this.landingPage.isAt();
        this.landingPage.clickOnGotItButtonIfNeeds().minimizeChatWidget().clickOnTrackingMenu();
        this.trackingPage.isAt();
        this.trackingPage.clickOnSearchButton();
        String id = this.trackingPage.getTrackingId();
        this.trackingPage.clickOnFirstTrackingId();
        this.orderDetailsPage.isAt();
        this.orderDetailsPage.isTrackingIdValid(id);
        this.orderDetailsPage.clickOnPrintAirwayButton().clickOnOneBillsPerPage().clickOnPrintButton();
        this.airwayBillPage.isAt();
        this.airwayBillPage.verifyTrackingIdDetail(id);
    }

}
