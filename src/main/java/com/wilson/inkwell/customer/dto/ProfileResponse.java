package com.wilson.inkwell.customer.dto;

import java.time.LocalDate;

public record ProfileResponse(
    String firstName,
    String lastName,
    LocalDate dateOfBirth,
    String photo
) {
    
}
