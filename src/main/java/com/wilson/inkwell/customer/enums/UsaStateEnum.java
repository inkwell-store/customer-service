package com.wilson.inkwell.customer.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum UsaStateEnum {

    ALABAMA("AL", "Alabama"),
    ALASKA("AK", "Alaska"),
    ARIZONA("AZ", "Arizona"),
    ARKANSAS("AR", "Arkansas"),
    CALIFORNIA("CA", "California"),
    COLORADO("CO", "Colorado"),
    CONNECTICUT("CT", "Connecticut"),
    DELAWARE("DE", "Delaware"),
    DISTRICT_OF_COLUMBIA("DC", "District of Columbia"),
    FLORIDA("FL", "Florida"),
    GEORGIA("GA", "Georgia"),
    HAWAII("HI", "Hawaii"),
    IDAHO("ID", "Idaho"),
    ILLINOIS("IL", "Illinois"),
    INDIANA("IN", "Indiana"),
    IOWA("IA", "Iowa"),
    KANSAS("KS", "Kansas"),
    KENTUCKY("KY", "Kentucky"),
    LOUISIANA("LA", "Louisiana"),
    MAINE("ME", "Maine"),
    MARYLAND("MD", "Maryland"),
    MASSACHUSETTS("MA", "Massachusetts"),
    MICHIGAN("MI", "Michigan"),
    MINNESOTA("MN", "Minnesota"),
    MISSISSIPPI("MS", "Mississippi"),
    MISSOURI("MO", "Missouri"),
    MONTANA("MT", "Montana"),
    NEBRASKA("NE", "Nebraska"),
    NEVADA("NV", "Nevada"),
    NEW_HAMPSHIRE("NH", "New Hampshire"),
    NEW_JERSEY("NJ", "New Jersey"),
    NEW_MEXICO("NM", "New Mexico"),
    NEW_YORK("NY", "New York"),
    NORTH_CAROLINA("NC", "North Carolina"),
    NORTH_DAKOTA("ND", "North Dakota"),
    OHIO("OH", "Ohio"),
    OKLAHOMA("OK", "Oklahoma"),
    OREGON("OR", "Oregon"),
    PENNSYLVANIA("PA", "Pennsylvania"),
    RHODE_ISLAND("RI", "Rhode Island"),
    SOUTH_CAROLINA("SC", "South Carolina"),
    SOUTH_DAKOTA("SD", "South Dakota"),
    TENNESSEE("TN", "Tennessee"),
    TEXAS("TX", "Texas"),
    UTAH("UT", "Utah"),
    VERMONT("VT", "Vermont"),
    VIRGINIA("VA", "Virginia"),
    WASHINGTON("WA", "Washington"),
    WEST_VIRGINIA("WV", "West Virginia"),
    WISCONSIN("WI", "Wisconsin"),
    WYOMING("WY", "Wyoming");

    private final String abbreviation;
    private final String name;

    UsaStateEnum(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    /**
     * Look up state by two-letter abbreviation (case-insensitive).
     */
    public static UsaStateEnum valueOfAbbreviation(String abbreviation) {
        for (UsaStateEnum state : values()) {
            if (state.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown USA state abbreviation: " + abbreviation);
    }

    /**
     * Look up state by full name (case-insensitive).
     */
    public static UsaStateEnum valueOfName(String name) {
        for (UsaStateEnum state : values()) {
            if (state.getName().equalsIgnoreCase(name)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown USA state: " + name);
    }

    @JsonCreator
    public static UsaStateEnum fromAbbreviation(String abbreviation) {
        for (UsaStateEnum state : values()) {
            if (state.abbreviation.equalsIgnoreCase(abbreviation)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown USA state abbreviation: " + abbreviation);
    }
}
