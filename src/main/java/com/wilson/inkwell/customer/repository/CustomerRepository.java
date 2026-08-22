package com.wilson.inkwell.customer.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilson.inkwell.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    
}
