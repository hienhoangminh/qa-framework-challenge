package com.rocktester.automation.qaframework.cucumber.steps;

import com.rocktester.automation.qaframework.entity.OAuthResponseDTO;
import com.rocktester.automation.qaframework.entity.OrderRequestDTO;
import com.rocktester.automation.qaframework.entity.OrderResponseDTO;
import com.rocktester.automation.qaframework.entity.TrackingInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ContextSharing {
    public String token;
    public OrderRequestDTO orderRequest;
    public ResponseEntity<OrderResponseDTO> orderResponse;
    TrackingInfo trackingInfo;
    ResponseEntity<OAuthResponseDTO> authentication;
}
