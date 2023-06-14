package com.rocktester.automation.qaframework.cucumber.steps;

import com.rocktester.automation.qaframework.core.helpers.DataGeneratorHelpers;
import com.rocktester.automation.qaframework.entity.OAuthRequestDTO;
import com.rocktester.automation.qaframework.entity.OAuthResponseDTO;
import com.rocktester.automation.qaframework.entity.OrderRequestDTO;
import com.rocktester.automation.qaframework.httpclient.NinjaVanClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class CreateOrderSteps{

    @Autowired
    private NinjaVanClient client;

    @Autowired
    private ContextSharing contextSharing;

    @Value("${client_id}")
    private String clientId;

    @Value("${client_secret}")
    private String clientSecret;

    @Given("shipper authenticate to Ninja Van system")
    public void shipper_authenticate_to_ninja_van_system() {
        contextSharing.authentication = client.authenticate(OAuthRequestDTO.builder().clientId(clientId).clientSecret(clientSecret).build());
    }

    @Then("QA verifies that the HTTP response code is {int}")
    public void qa_verifies_that_the_http_response_code_is(Integer statusCode) {
        ResponseEntity<OAuthResponseDTO> authenticationResponse = contextSharing.authentication;
        client.verifyResponseStatus(authenticationResponse, HttpStatus.valueOf(statusCode));
    }

    @When("shipper retrieves its access token")
    public void shipper_retrieves_its_access_token() {
        ResponseEntity<OAuthResponseDTO> authenticationResponse = contextSharing.authentication;
        contextSharing.token = client.retrieveAccessToken(authenticationResponse);
    }

    @When("shipper send order create request")
    public void shipper_send_order_create_request() {
        contextSharing.orderRequest = DataGeneratorHelpers.generateOrderRequestDTO();
    }

    @When("shipper provides the access token in the request header")
    public void shipper_provides_the_access_token_in_the_request_header() {
        HttpHeaders headers = client.setAuthorization(contextSharing.token);
        OrderRequestDTO orderRequestDTO = contextSharing.orderRequest;
        contextSharing.orderResponse = client.createOrder(headers, orderRequestDTO);
    }

}
