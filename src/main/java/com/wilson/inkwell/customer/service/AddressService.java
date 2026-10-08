package com.wilson.inkwell.customer.service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.wilson.inkwell.customer.dto.AddressResponse;
import com.wilson.inkwell.customer.dto.NewAddressRequest;
import com.wilson.inkwell.customer.dto.UpdateAddressRequest;
import com.wilson.inkwell.customer.entity.Address;
import com.wilson.inkwell.customer.entity.Customer;
import com.wilson.inkwell.customer.exception.AddressNotFoundException;
import com.wilson.inkwell.customer.exception.CustomerNotFoundException;
import com.wilson.inkwell.customer.repository.AddressRepository;
import com.wilson.inkwell.customer.repository.CustomerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AddressService {
    
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;

    @Transactional
    public AddressResponse addNewAddress(NewAddressRequest newAddress) {
        
        // grab the UUID from the SecurityContextHolder
        UUID uuid = getAuthenticatedUuid();

        Customer customer = customerRepository.getCustomerByCredentialId(uuid).orElseThrow(
            () -> new CustomerNotFoundException("Customer not found")
        );

        Address address = new Address();
        address.setName(newAddress.name());
        address.setCity(newAddress.city());
        address.setStreet(newAddress.street());
        address.setNumber(newAddress.number());
        address.setPostalCode(newAddress.postalCode());
        address.setState(newAddress.state());
        address.setType(newAddress.type());
        address.setLine(newAddress.line());
        address.setCustomer(customer);

        return convertFromEntityToDto(addressRepository.save(address));

    }
    
    public AddressResponse getAddressById(long id) {
        UUID uuid = getAuthenticatedUuid();
        
        Address address = addressRepository.getAddressByIdForCustomer(id, uuid).orElseThrow(
            () -> new AddressNotFoundException("Address not found")
        );

        return convertFromEntityToDto(address);
    }

    public Set<AddressResponse> getAddressList() {
        UUID uuid = getAuthenticatedUuid();
        Set<AddressResponse> addressList = new HashSet<>();

        addressRepository.getAddressListForCustomer(uuid).forEach(
            e -> addressList.add(convertFromEntityToDto(e))
        );

        return addressList;
    }

    public void deleteAddressById(long id) {
        UUID uuid = getAuthenticatedUuid();
        
        Address address = addressRepository.getAddressByIdForCustomer(id, uuid).orElseThrow(
            () -> new AddressNotFoundException("Address not found")
        );

        addressRepository.delete(address);
    }

    public AddressResponse updateAddressById(UpdateAddressRequest request, long id) {

        UUID uuid = getAuthenticatedUuid();
        
        Address address = addressRepository.getAddressByIdForCustomer(id, uuid).orElseThrow(
            () -> new AddressNotFoundException("Address not found")
        );

        // TODO is there a better pattern for this?
        if(request.name() != null) address.setName(request.name()); 
        if(request.city() != null) address.setCity(request.city()); 
        if(request.street() != null) address.setStreet(request.street()); 
        if(request.state() != null) address.setState(request.state()); 
        if(request.postalCode() != null) address.setPostalCode(request.postalCode()); 
        if(request.number() != null) address.setNumber(request.number());
        if(request.line() != null) address.setLine(request.line());
        if(request.type() != null) address.setType(request.type());

        return convertFromEntityToDto(addressRepository.save(address));

    }

    private AddressResponse convertFromEntityToDto(Address entity) {

        return new AddressResponse(
            entity.getId(),
            entity.getName(), 
            entity.getStreet(), 
            entity.getNumber(), 
            entity.getCity(), 
            entity.getState(), 
            entity.getPostalCode(), 
            entity.getLine(), 
            entity.getType()
        );

    }

    private UUID getAuthenticatedUuid() {
        return UUID.fromString(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
