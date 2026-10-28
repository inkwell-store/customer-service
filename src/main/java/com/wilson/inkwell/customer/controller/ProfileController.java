package com.wilson.inkwell.customer.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wilson.inkwell.customer.dto.ProfileResponse;
import com.wilson.inkwell.customer.dto.UpdateProfileRequest;
import com.wilson.inkwell.customer.service.CustomerService;
import com.wilson.inkwell.customer.utils.ResourceName;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/" + ResourceName.API + "/" + ResourceName.CUSTOMERS + "/" + ResourceName.ME + "/"+ ResourceName.PROFILE)
@RequiredArgsConstructor
public class ProfileController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getProfile(@RequestParam String attributes) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(customerService.getProfile(attributes));
    }

    @PatchMapping
    public ResponseEntity<ProfileResponse> updateProfile(@RequestBody UpdateProfileRequest updateProfileRequest) {
        return ResponseEntity.status(HttpStatus.OK).body(
                customerService.patchProfile(updateProfileRequest));
    }

}
