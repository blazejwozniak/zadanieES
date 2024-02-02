package com.energysolution.mvp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddressDTO(
        @Size(max = 128) String name,
        @NotBlank @Size(max = 128) String street,
        @NotBlank @Size(max = 128) String buildingNumber,
        @Size(max = 128) String apartmentNumber,
        @NotBlank @Size(max = 128) String city,
        @NotBlank @Size(max = 128) String postalCode,
        @NotBlank @Size(max = 128) String country
) {}
