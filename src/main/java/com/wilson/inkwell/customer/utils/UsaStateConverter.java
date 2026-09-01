package com.wilson.inkwell.customer.utils;

import com.wilson.inkwell.customer.enums.UsaStateEnum;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UsaStateConverter implements AttributeConverter<UsaStateEnum, String> {

    @Override
    public String convertToDatabaseColumn(UsaStateEnum attribute) {
        return attribute.getAbbreviation();
    }

    @Override
    public UsaStateEnum convertToEntityAttribute(String dbData) {
        return UsaStateEnum.valueOfAbbreviation(dbData); 
    }
    
}
