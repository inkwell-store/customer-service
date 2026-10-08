package com.wilson.inkwell.customer.dto;

import com.wilson.inkwell.customer.enums.AddressTypeEnum;
import com.wilson.inkwell.customer.enums.UsaStateEnum;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Models a POST request to create a new address for a Customer user. The Customer
 * information will be recovered from the SecurityContextHolder.
 */
public record NewAddressRequest(
    
    String name,

    @NotBlank(message = "street is required")
    String street,
    
    @NotNull(message = "number is required")
    Integer number,
    
    @NotBlank(message = "city is required")
    String city,
    
    @NotNull(message = "state is required")
    UsaStateEnum state,
    
    @NotBlank(message = "postal code is required")
    String postalCode,
    
    String line,
    
    @NotNull(message = "address type is required")
    AddressTypeEnum type
) {
    
}
