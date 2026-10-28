package com.wilson.inkwell.customer.enums;

import java.util.Arrays;

public enum ProfileAttributes {
    
    FIRST_NAME("first_name"),
    LAST_NAME("last_name"),
    PHOTO("photo"),
    DATE_OF_BIRTH("date_of_birth");

    private final String value;

    ProfileAttributes(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    public static ProfileAttributes fromValue(String value) {
        return Arrays.stream(values())
                     .filter(attribute -> attribute.value.equals(value))
                     .findFirst()
                     // for safety I'll let this here
                     .orElseThrow(() -> new IllegalArgumentException("attribute: " + value + " is invalid for enum ProfileAttributes"));
    }
}
