package com.wilson.inkwell.customer.dto;

import java.time.LocalDate;

public record UpdateProfileRequest(
    String firstName,
    String lastName,
    LocalDate dateOfBirth
) {
    
}
