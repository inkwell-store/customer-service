package com.wilson.inkwell.customer.entity;

import com.wilson.inkwell.customer.enums.AddressTypeEnum;
import com.wilson.inkwell.customer.enums.UsaStateEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Entity that models a USA-style address.
 */
@Entity
@Table(name = "ADDRESS_TBL")
@Setter
@Getter
@NoArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;
    
    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "state", nullable = false)
    private UsaStateEnum state;

    @Column(name = "postal_code", nullable = false)
    private String postalCode;

    @Column(name = "line")
    private String line;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private AddressTypeEnum type;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

}
