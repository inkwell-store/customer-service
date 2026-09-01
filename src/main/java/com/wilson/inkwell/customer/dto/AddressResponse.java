package com.wilson.inkwell.customer.dto;

import com.wilson.inkwell.customer.enums.AddressTypeEnum;
import com.wilson.inkwell.customer.enums.UsaStateEnum;

public record AddressResponse(
    long id,
    String street,
    int number,
    String city,
    UsaStateEnum state,
    String postalCode,
    String line,
    AddressTypeEnum type
) {
    
}
