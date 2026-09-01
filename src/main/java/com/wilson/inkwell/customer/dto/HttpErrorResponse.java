package com.wilson.inkwell.customer.dto;

import java.time.Instant;

import com.wilson.inkwell.customer.enums.HttpErrorType;

public record HttpErrorResponse(
    int status,
    HttpErrorType error,
    String message,
    Instant time
) {
    
}
