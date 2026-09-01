package com.wilson.inkwell.customer.dto;

import com.wilson.inkwell.customer.enums.AddressTypeEnum;
import com.wilson.inkwell.customer.enums.UsaStateEnum;

/**
 * Models a request to either create a new Address or 
 * to update an existing one. The Customer information
 * will be recovered from the SecurityContextHolder.
 */
public record NewAddressRequest(
    String street,
    int number,
    String city,
    UsaStateEnum state,
    String postalCode,
    String line,
    AddressTypeEnum type
) {
    
}
