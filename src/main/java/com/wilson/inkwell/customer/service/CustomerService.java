package com.wilson.inkwell.customer.service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import com.wilson.inkwell.customer.enums.ProfileAttributes;
import com.wilson.inkwell.customer.dto.ProfileResponse;
import com.wilson.inkwell.customer.dto.UpdateProfileRequest;
import com.wilson.inkwell.customer.entity.Customer;
import com.wilson.inkwell.customer.exception.CustomerNotFoundException;
import com.wilson.inkwell.customer.exception.UnsupportedParameterException;
import com.wilson.inkwell.customer.repository.CustomerRepository;
import com.wilson.inkwell.customer.utils.UnsetEntityField;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    private final Set<String> CUSTOMER_SERVICE_ATTRIBUTES = Set.of(
        "first_name",
        "last_name",
        "photo",
        "date_of_birth");

    public void createNewCustomer(UUID credentialUuid) {

        Customer newCustomer = new Customer();
        newCustomer.setCredentialId(credentialUuid);
        newCustomer.setCreatedAt(Instant.now());
        newCustomer.setLastName(UnsetEntityField.NOT_SET_YET);
        newCustomer.setFirstName(UnsetEntityField.NOT_SET_YET);

        try {
            customerRepository.save(newCustomer);
        } catch (DataIntegrityViolationException e) {
            // FIXME this is the NOT the correct way to treat the exception in this case, I
            // should look to find a better way to treat this here.
            e.printStackTrace();
        }

    }
    
    public Map<String, Object> getProfile(String attributeStringList) {

        Map<String, Object> responseBody = new HashMap<>();
        Set<String> requestAttributes = Set.of(attributeStringList.split(","));

        for(String att : requestAttributes) {
            if(!CUSTOMER_SERVICE_ATTRIBUTES.contains(att)) {
                throw new UnsupportedParameterException("Attribute " + att + " not supported for resource profile.");
            }
        }

        Customer customer = customerRepository.getCustomerByCredentialId(getAuthenticatedUuid()).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found"));

        for (String att : requestAttributes) {

            switch (ProfileAttributes.fromValue(att)) {
                case FIRST_NAME:
                    responseBody.put(ProfileAttributes.FIRST_NAME.value(), customer.getFirstName());
                    break;
                case LAST_NAME:
                    responseBody.put(ProfileAttributes.LAST_NAME.value(), customer.getLastName());
                    break;
                case PHOTO:
                    responseBody.put(ProfileAttributes.PHOTO.value(), customer.getPhoto());
                    break;
                case DATE_OF_BIRTH:
                    responseBody.put(ProfileAttributes.DATE_OF_BIRTH.value(), customer.getDateOfBirth());
                    break;
            }
        }


        return responseBody;
    }

    @Transactional
    public ProfileResponse patchProfile(UpdateProfileRequest request) {
        ;
        Customer customer = customerRepository.getCustomerByCredentialId(getAuthenticatedUuid()).orElseThrow(
                () -> new CustomerNotFoundException("Customer not found"));

        if(request.firstName() != null) customer.setFirstName(request.firstName());
        if(request.lastName() != null) customer.setLastName(request.lastName());
        if(request.dateOfBirth() != null) customer.setDateOfBirth(request.dateOfBirth());

        return convertEntityToDTO(customerRepository.save(customer));
    }

    // TODO use a selective query to only fetch the information required instead of
    // grabbing the whole entity
    public ProfileResponse convertEntityToDTO(Customer customer) {
        return new ProfileResponse(
                customer.getFirstName().equals(UnsetEntityField.NOT_SET_YET) ? null : customer.getFirstName(), 
                customer.getLastName().equals(UnsetEntityField.NOT_SET_YET) ? null : customer.getLastName(), 
                customer.getDateOfBirth(), 
                customer.getPhoto());
    }

    private UUID getAuthenticatedUuid() {
        return UUID.fromString(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
