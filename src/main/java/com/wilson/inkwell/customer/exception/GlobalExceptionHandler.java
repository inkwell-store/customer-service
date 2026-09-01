package com.wilson.inkwell.customer.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wilson.inkwell.customer.dto.HttpErrorResponse;
import com.wilson.inkwell.customer.enums.HttpErrorType;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(AddressNotFoundException.class)
    public ResponseEntity<HttpErrorResponse> handleAddressNotFoundException(AddressNotFoundException e) {
        int status = HttpStatus.NOT_FOUND.value();
        HttpErrorResponse body = new HttpErrorResponse(
            status, HttpErrorType.RESOURCE_NOT_FOUND, e.getMessage(), Instant.now());
        return ResponseEntity.status(status).body(body);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<HttpErrorResponse> handleAddressNotFoundException(CustomerNotFoundException e) {
        int status = HttpStatus.NOT_FOUND.value();
        HttpErrorResponse body = new HttpErrorResponse(
            status, HttpErrorType.RESOURCE_NOT_FOUND, e.getMessage(), Instant.now());
        return ResponseEntity.status(status).body(body);
    }
    
}
