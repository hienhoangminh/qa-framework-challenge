package com.rocktester.automation.qaframework.cucumber.steps;

import com.rocktester.automation.qaframework.SpringBaseTestNGTest;
import com.rocktester.automation.qaframework.core.annotation.LazyAutowired;
import com.rocktester.automation.qaframework.core.exception.AutomationException;
import com.rocktester.automation.qaframework.core.service.WindowSwitchService;
import com.rocktester.automation.qaframework.entity.TrackingInfo;
import com.rocktester.automation.qaframework.page.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class AirwayBillSteps{

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

    @LazyAutowired
    private ContextSharing contextSharing;

    @Given("shipper opens Ninja dashboard login page")
    public void shipper_opens_ninja_dashboard_login_page() {
        this.loginPage.goTo();
        this.loginPage.isAt();
    }

    @When("shipper login by using credentials {string} and {string}")
    public void shipper_login_by_using_credentials_and(String email, String password) {
        this.loginPage
                .enterEmailInput(email)
                .enterPasswordInput(password)
                .clickOnLoginButton();
    }

    @Then("shipper arrives at landing page")
    public void shipper_arrives_at_landing_page() {
        this.landingPage.isAt();
    }

    @When("shipper goes to the tracking page")
    public void shipper_goes_to_the_tracking_page() {
        this.landingPage
                .clickOnGotItButtonIfNeeds()
                .minimizeChatWidget()
                .clickOnTrackingMenu();
    }

    @When("shipper clicks on Search button")
    public void shipper_clicks_on_search_button() {
        this.trackingPage.isAt();
        this.trackingPage.clickOnSearchButton();
    }

    @When("shipper selects the first tracking ID in the table")
    public void shipper_selects_the_first_tracking_id_in_the_table() {
        this.trackingPage.clickOnFirstTrackingId();
        contextSharing.trackingInfo = new TrackingInfo(this.trackingPage.getTrackingId());
    }

    @Then("QA verify that Order details page is shown")
    public void qa_verify_that_order_details_page_is_shown() {
        this.orderDetailsPage.isAt();
        this.orderDetailsPage.isTrackingIdValid(contextSharing.trackingInfo.getId());
    }

    @When("shipper clicks Print Airway Bill button")
    public void shipper_clicks_print_airway_bill_button() {
        this.orderDetailsPage.clickOnPrintAirwayButton();
    }

    @When("shipper selects {int} bills per page in Print Airway Bills dialog")
    public void shipper_selects_bills_per_page_in_print_airway_bills_dialog(Integer int1) {
        this.orderDetailsPage.clickOnOneBillsPerPage();
    }

    @When("shipper clicks Print button in Print Airways Bills dialog")
    public void shipper_clicks_print_button_in_print_airways_bills_dialog() {
        this.orderDetailsPage.clickOnPrintButton();

    }

    @Then("QA verify that the tracking ID text in the PDF file is correct")
    public void qa_verify_that_the_tracking_id_text_in_the_pdf_file_is_correct() throws AutomationException {
        this.airwayBillPage.isAt();
        this.airwayBillPage.verifyTrackingIdDetail(contextSharing.trackingInfo.getId());
    }
}
