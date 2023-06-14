package com.rocktester.automation.qaframework.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AddressDTO {
    @SerializedName("address1")
    private String address1;
    @SerializedName("address2")
    private String address2;
    @SerializedName("country")
    private String country;
    @SerializedName("postcode")
    private String postcode;
}
