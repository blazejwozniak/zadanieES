package com.energysolution.mvp.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record IoTDeviceDTO(
        @NotBlank @Size(max = 128) String deviceId,
        @NotNull LocalDateTime creationDate,
        LocalDateTime modificationDate,
        LocalDateTime startDate,
        LocalDateTime endDate,
        AddressDTO addressDTO
) {}
