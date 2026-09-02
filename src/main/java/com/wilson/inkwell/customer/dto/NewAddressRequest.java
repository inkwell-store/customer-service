package com.wilson.inkwell.customer.dto;

import com.wilson.inkwell.customer.enums.AddressTypeEnum;
import com.wilson.inkwell.customer.enums.UsaStateEnum;

import jakarta.validation.constraints.NotBlank;

/**
 * Models a POST request to create a new address for a Customer user. The Customer
 * information will be recovered from the SecurityContextHolder.
 */
public record NewAddressRequest(
    
    @NotBlank(message = "street is required")
    String street,
    
    @NotBlank(message = "number is required")
    int number,
    
    @NotBlank(message = "city is required")
    String city,
    
    @NotBlank(message = "state is required")
    UsaStateEnum state,
    
    @NotBlank(message = "postal code is required")
    String postalCode,
    
    String line,
    
    @NotBlank(message = "address type is required")
    AddressTypeEnum type
) {
    
}
