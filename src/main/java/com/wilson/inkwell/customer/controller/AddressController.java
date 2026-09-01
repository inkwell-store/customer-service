package com.wilson.inkwell.customer.controller;

import org.springframework.web.bind.annotation.RestController;

import com.wilson.inkwell.customer.dto.AddressResponse;
import com.wilson.inkwell.customer.dto.NewAddressRequest;
import com.wilson.inkwell.customer.dto.UpdateAddressRequest;
import com.wilson.inkwell.customer.service.AddressService;

import lombok.RequiredArgsConstructor;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/api/customer/me/address/")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @PostMapping
    public ResponseEntity<Void> handleNewAddressRequest(@RequestBody NewAddressRequest newAddress) {
        addressService.addNewAddress(newAddress);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("{addressId}")
    public ResponseEntity<AddressResponse> handleGetAddressById(@PathVariable(name = "addressId") long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            addressService.getAddressById(id)
        );
    }

    @GetMapping
    public ResponseEntity<Set<AddressResponse>> handleGetAddressSet() {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
            addressService.getAddressList()
        );
    }

    @DeleteMapping("{addressId}")
    public ResponseEntity<Void> handleDeleteAddress(@PathVariable(name = "addressId") long id) {
        addressService.deleteAddressById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("{addressId}")
    public ResponseEntity<Void> handlePatchAddress(
        @RequestBody UpdateAddressRequest body,
        @PathVariable(name = "addressId") long id
    ) {
        addressService.updateAddressById(body, id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    
}
