package com.rocktester.automation.qaframework.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OAuthResponseDTO {

    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("expires")
    private long expires;
}
