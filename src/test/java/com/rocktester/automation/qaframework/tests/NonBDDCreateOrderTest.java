package com.rocktester.automation.qaframework.tests;

import com.rocktester.automation.qaframework.SpringBaseTestNGTest;
import com.rocktester.automation.qaframework.core.exception.AutomationException;
import com.rocktester.automation.qaframework.core.helpers.DataGeneratorHelpers;
import com.rocktester.automation.qaframework.entity.OAuthRequestDTO;
import com.rocktester.automation.qaframework.entity.OAuthResponseDTO;
import com.rocktester.automation.qaframework.entity.OrderRequestDTO;
import com.rocktester.automation.qaframework.entity.OrderResponseDTO;
import com.rocktester.automation.qaframework.httpclient.NinjaVanClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class NonBDDCreateOrderTest extends SpringBaseTestNGTest{

    @Autowired
    private NinjaVanClient client;

    private HttpHeaders headers = new HttpHeaders();

    @Value("${client_id}")
    private String clientId;

    @Value("${client_secret}")
    private String clientSecret;

    @Test
    public void authenticate() {
        ResponseEntity<OAuthResponseDTO> authResponse = client.authenticate(OAuthRequestDTO.builder().clientId(clientId).clientSecret(clientSecret).build());
        assertThat(authResponse.getStatusCode().value()).isEqualTo(200);
        headers = client.setAuthorization(Objects.requireNonNull(authResponse.getBody()).getAccessToken());
    }

    @Test(dependsOnMethods = {"authenticate"}, alwaysRun = true)
    public void checkDetail() throws AutomationException {
        OrderRequestDTO orderRequestDTO = DataGeneratorHelpers.generateOrderRequestDTO();
        ResponseEntity<OrderResponseDTO> orderResponse =client.createOrder(headers, orderRequestDTO);
        assertThat(orderResponse.getStatusCode().value()).isEqualTo(200);
        assertThat(orderResponse.getBody()).isEqualTo(OrderResponseDTO.builder().status("OK").build());
    }
}
