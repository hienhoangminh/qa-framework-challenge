package com.rocktester.automation.qaframework.core.helpers;

import com.github.javafaker.Faker;
import com.rocktester.automation.qaframework.entity.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataGeneratorHelpers {
    private static final Faker faker = new Faker();
    private static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    private DataGeneratorHelpers() {
    }

    public static AddressDTO generateRandomAddress() {
        return AddressDTO.builder()
                .address1(faker.address().streetAddress())
                .address2(faker.address().secondaryAddress())
                .country("SG")
                .postcode(faker.address().zipCode()).build();
    }

    private static PersonDetailDTO generatePersonDetailDTO() {
        return PersonDetailDTO.builder()
                .name(generateRandomName())
                .phoneNumber(generateRandomPhoneNumber())
                .email(generateRandomEmail())
                .address(generateRandomAddress()).build();
    }

    public static OrderRequestDTO generateOrderRequestDTO() {
        OrderRequestDTO orderRequestDTO = new OrderRequestDTO();
        orderRequestDTO.setServiceType(ServiceEnum.ServiceType.PARCEL.getService());
        orderRequestDTO.setServiceLevel(ServiceEnum.ServiceLevel.STANDARD.getLevel());
        orderRequestDTO.setFrom(generatePersonDetailDTO());
        orderRequestDTO.setTo(generatePersonDetailDTO());
        orderRequestDTO.setParcelJob(generateParcelJobDTO());
        return orderRequestDTO;
    }

    private static ParcelJobDTO generateParcelJobDTO() {
        ParcelJobDTO parcelJobDTO = new ParcelJobDTO();
        parcelJobDTO.setPickupDate(generateDateFromFutureWithFormat(DATE_FORMAT, 3));
        parcelJobDTO.setPickupAddress(generatePersonDetailDTO());
        parcelJobDTO.setPickupTimeslot(generatePickUpTimeslot());
        parcelJobDTO.setDeliveryTimeslot(generateDeliveryTimeslot());
        return parcelJobDTO;
    }

    private static TimeslotDTO generatePickUpTimeslot() {
        TimeslotDTO timeslotDTO = new TimeslotDTO();
        timeslotDTO.setStartTime(ServiceEnum.ServiceTimeslot.randomTimeslot().split("-")[0]);
        timeslotDTO.setEndTime(ServiceEnum.ServiceTimeslot.randomTimeslot().split("-")[1]);
        timeslotDTO.setTimezone(ServiceEnum.ServiceTimezone.ASIA_SINGAPORE.getTimeZone());
        return timeslotDTO;
    }

    private static TimeslotDTO generateDeliveryTimeslot() {
        TimeslotDTO timeslotDTO = new TimeslotDTO();
        timeslotDTO.setStartTime(ServiceEnum.ServiceTimeslot.FROM_NINE_TO_TWENTY_TWO.getTimeSlot().split("-")[0]);
        timeslotDTO.setEndTime(ServiceEnum.ServiceTimeslot.FROM_NINE_TO_TWENTY_TWO.getTimeSlot().split("-")[1]);
        timeslotDTO.setTimezone(ServiceEnum.ServiceTimezone.ASIA_SINGAPORE.getTimeZone());
        return timeslotDTO;
    }

    private static String generateDateFromFutureWithFormat(SimpleDateFormat format, int number) {
        Date future = Date.from(faker.date().future(number, TimeUnit.DAYS).toInstant());
        return format.format(future);
    }

    public static String generateRandomName() {
        return faker.name().fullName();
    }

    public static String generateRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public static String generateRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static int generateRandomNumber() {
        return faker.number().numberBetween(1000000, 9999999);
    }

    public static int generateRandomNumberWithinRange(int low, int high) {
        return faker.number().numberBetween(low, high);
    }

}
