package com.wilson.inkwell.customer.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/customer/")
public class CustomerController {

    @GetMapping("hello")
    public String sayHello() {
        return "Hello from CustomerController";
    }
    
    @GetMapping("private-hello")
    public String getMethodName() {
        return "Hello from a private endpoint in CustomerController";
    }

}
