package com.wilson.inkwell.customer.dto;

import java.time.Instant;
import java.util.Map;

import com.wilson.inkwell.customer.enums.HttpErrorType;

public record HttpMultipleErrorResponseBody(
    int status,
    Instant timestamp,
    HttpErrorType error,
    Map<String, String> messages
) {

}
