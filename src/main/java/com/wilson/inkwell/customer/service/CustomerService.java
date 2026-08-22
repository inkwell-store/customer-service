package com.wilson.inkwell.customer.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.wilson.inkwell.customer.entity.Customer;
import com.wilson.inkwell.customer.exception.CustomerAlreadyRegisteredException;
import com.wilson.inkwell.customer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createNewCustomer(UUID credentialUuid) {

        Customer newCustomer = new Customer();
        newCustomer.setCredentialId(credentialUuid);
        newCustomer.setCreatedAt(Instant.now());

        try {
            customerRepository.save(newCustomer);
        } catch (DataIntegrityViolationException e) {
            // FIXME this is the NOT the correct way to treat the exception in this case, I
            // should look to find a better way to treat this here.
            e.printStackTrace();
        }

    }

}
