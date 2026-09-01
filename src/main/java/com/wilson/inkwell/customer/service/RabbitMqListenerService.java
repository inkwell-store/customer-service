package com.wilson.inkwell.customer.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.wilson.inkwell.customer.dto.CredentialCreationEvent;

@Service
public class RabbitMqListenerService {

    private final CustomerService customerService;

    public RabbitMqListenerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    // @RabbitListener(queues = "customer.credential-queue")
    // public void processCredentialCreationEvent(CredentialCreationEvent event) {
    //     customerService.createNewCustomer(event.credentialKey());
    // }

}
