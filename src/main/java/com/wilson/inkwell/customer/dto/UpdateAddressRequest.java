package com.wilson.inkwell.customer.dto;

import com.wilson.inkwell.customer.enums.AddressTypeEnum;
import com.wilson.inkwell.customer.enums.UsaStateEnum;

/**
 * Models a PATCH request to udpate an address for a Customer user. The Customer
 * information will be recovered from the SecurityContextHolder.
 */
public record UpdateAddressRequest(
    String street,
    Integer number,
    String city,
    UsaStateEnum state,
    String postalCode,
    String line,
    AddressTypeEnum type
) {
    
}
