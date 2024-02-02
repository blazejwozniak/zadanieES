package com.energysolution.mvp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record DeviceConfigurationDTO(
        @NotBlank @Size(max = 128) String deviceId,
        @NotBlank @Size(max = 10000) String configuration,
        @NotNull LocalDateTime creationDate,
        @NotNull LocalDateTime modificationDate
) {}
