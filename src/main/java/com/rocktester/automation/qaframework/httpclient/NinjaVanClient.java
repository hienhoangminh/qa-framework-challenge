package com.rocktester.automation.qaframework.httpclient;

import com.rocktester.automation.qaframework.entity.OAuthRequestDTO;
import com.rocktester.automation.qaframework.entity.OAuthResponseDTO;
import com.rocktester.automation.qaframework.entity.OrderRequestDTO;
import com.rocktester.automation.qaframework.entity.OrderResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

@Service
public class NinjaVanClient {

    @Value("${baseApi}")
    private String baseApi;

    @Value("${user_service}")
    private String userServicePath;

    @Value("${order_service}")
    private String orderServicePath;

    @Autowired
    private TestRestTemplate testRestTemplate;

    public ResponseEntity<OAuthResponseDTO> authenticate(OAuthRequestDTO oAuthRequestDTO) {
        return testRestTemplate.postForEntity(baseApi + userServicePath, oAuthRequestDTO, OAuthResponseDTO.class);
    }

    public <T> void verifyResponseStatus(ResponseEntity<T> response, HttpStatus statusCode) {
        assertThat(response.getStatusCode().value()).isEqualTo(statusCode.value());
    }

    public String retrieveAccessToken(ResponseEntity<OAuthResponseDTO> response) {
        return Objects.requireNonNull(response.getBody()).getAccessToken();
    }

    public HttpHeaders setAuthorization(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        return headers;
    }

    public ResponseEntity<OrderResponseDTO> createOrder(HttpHeaders headers, OrderRequestDTO orderRequestDTO) {
        HttpEntity<OrderRequestDTO> entity = new HttpEntity<>(orderRequestDTO, headers);
        return testRestTemplate.postForEntity(baseApi + orderServicePath, entity, OrderResponseDTO.class);
    }

}
