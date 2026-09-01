package com.wilson.inkwell.customer.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wilson.inkwell.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    
    @Query("SELECT c FROM Customer c WHERE c.credentialId = :uuid")
    Optional<Customer> getCustomerByCredentialId(@Param("uuid") UUID uuid);

}
