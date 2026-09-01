package com.wilson.inkwell.customer.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wilson.inkwell.customer.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
    
    @Query("SELECT a FROM Address a WHERE a.id = :id AND a.customer.credentialId = :credentialId")
    Optional<Address> getAddressByIdForCustomer(
        @Param("id") long id,
        @Param("credentialId") UUID credentialId
    );

    @Query("SELECT a FROM Address a WHERE a.customer.credentialId = :credentialId")
    Set<Address> getAddressListForCustomer(@Param("credentialId") UUID credentialId);
}
