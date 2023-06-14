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
public class OrderRequestDTO {

    @SerializedName("service_type")
    private String serviceType;
    @SerializedName("service_level")
    private String serviceLevel;
    @SerializedName("from")
    private PersonDetailDTO from;
    @SerializedName("to")
    private PersonDetailDTO to;
    @SerializedName("parcel_job")
    private ParcelJobDTO parcelJob;

}
