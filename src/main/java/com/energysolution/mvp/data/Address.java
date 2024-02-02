package com.energysolution.mvp.data;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128)
    private String name;

    @Column(length = 128, nullable = false)
    private String street;

    @Column(length = 128, nullable = false)
    private String buildingNumber;

    @Column(length = 128)
    private String apartmentNumber;

    @Column(length = 128, nullable = false)
    private String city;

    @Column(length = 128, nullable = false)
    private String postalCode;

    @Column(length = 128, nullable = false)
    private String country;

}
