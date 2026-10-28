package com.wilson.inkwell.customer.exception;

/**
 * Exception thrown when a user tries to delete an address, while said address
 * is the last billing one.
 */
public class LastBillingAddressException extends RuntimeException {

    public LastBillingAddressException(String message) {
        super(message);
    }
    
}
