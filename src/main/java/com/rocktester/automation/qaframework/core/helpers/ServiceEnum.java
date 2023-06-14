package com.rocktester.automation.qaframework.core.helpers;

import lombok.Getter;

public class ServiceEnum {

    public enum ServiceType {
        PARCEL("Parcel");

        @Getter
        private final String service;

        ServiceType(String service) {
            this.service = service;
        }
    }


    public enum ServiceLevel {
        STANDARD("Standard");

        @Getter
        private final String level;

        ServiceLevel(String level) {
            this.level = level;
        }
    }

    public enum ServiceTimeslot {
        FROM_NINE_TO_TWELVE("09:00-12:00"),
        FROM_TWELVE_TO_FIFTEEN("12:00-15:00"),
        FROM_FIFTEEN_TO_EIGHTEEN("15:00-18:00"),
        FROM_EIGHTEEN_TO_TWENTY_TWO("18:00-22:00"),
        FROM_NINE_TO_EIGHTEEN("09:00-18:00"),
        FROM_NINE_TO_TWENTY_TWO("09:00-22:00");

        @Getter
        private final String timeSlot;

        ServiceTimeslot(String timeSlot) {
            this.timeSlot = timeSlot;
        }

        public static String randomTimeslot() {
            return ServiceTimeslot.values()[DataGeneratorHelpers.generateRandomNumberWithinRange(0, ServiceTimeslot.values().length - 1)].getTimeSlot();
        }
    }

    public enum ServiceTimezone {
        ASIA_SINGAPORE("Asia/Singapore");

        @Getter
        private final String timeZone;

        ServiceTimezone(String timeZone) {
            this.timeZone = timeZone;
        }
    }
}
