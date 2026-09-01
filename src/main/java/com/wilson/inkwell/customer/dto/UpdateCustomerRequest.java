package com.wilson.inkwell.customer.dto;

import java.time.LocalDate;

public record UpdateCustomerRequest(
    String firstName,
    String lastName,
    LocalDate dateOfBirth 
) {
    
}
