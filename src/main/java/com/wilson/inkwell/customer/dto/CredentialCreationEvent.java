package com.wilson.inkwell.customer.dto;

import java.util.UUID;

public record CredentialCreationEvent(String email, UUID credentialKey) {
    
}
