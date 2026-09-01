package com.wilson.inkwell.customer.dto;

import com.wilson.inkwell.customer.enums.AddressTypeEnum;
import com.wilson.inkwell.customer.enums.UsaStateEnum;

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
