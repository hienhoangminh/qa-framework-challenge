package com.rocktester.automation.qaframework.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ParcelJobDTO {
    @SerializedName("pickup_date")
    private String pickupDate;
    @JsonProperty("pickup_address")
    private PersonDetailDTO pickupAddress;
    @JsonProperty("pickup_timeslot")
    private TimeslotDTO pickupTimeslot;
    @JsonProperty("delivery_timeslot")
    private TimeslotDTO deliveryTimeslot;
}
