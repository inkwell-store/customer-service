package com.wilson.inkwell.customer.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wilson.inkwell.customer.dto.HttpErrorResponse;
import com.wilson.inkwell.customer.dto.HttpMultipleErrorResponseBody;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<HttpMultipleErrorResponseBody> handleBeanValidationException(MethodArgumentNotValidException e) {

        Map<String, String> messages = new HashMap<>();
        for (FieldError error : e.getBindingResult().getFieldErrors()) {
            messages.putIfAbsent(error.getField(), error.getDefaultMessage());
        }

        int httpStatus = HttpStatus.BAD_REQUEST.value();
        HttpMultipleErrorResponseBody body  = new HttpMultipleErrorResponseBody(
            httpStatus, Instant.now(), HttpErrorType.VALIDATION_ERROR, messages);

        return ResponseEntity.status(httpStatus).body(body);
    }
    
}
