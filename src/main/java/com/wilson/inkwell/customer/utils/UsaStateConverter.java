package com.wilson.inkwell.customer.utils;

import com.wilson.inkwell.customer.enums.UsaStateEnum;

import jakarta.persistence.AttributeConverter;

public class UsaStateConverter implements AttributeConverter<UsaStateEnum, String> {

    @Override
    public String convertToDatabaseColumn(UsaStateEnum attribute) {
        return attribute.getAbbreviation();
    }

    @Override
    public UsaStateEnum convertToEntityAttribute(String dbData) {
        return UsaStateEnum.valueOf(dbData); 
    }
    
}
