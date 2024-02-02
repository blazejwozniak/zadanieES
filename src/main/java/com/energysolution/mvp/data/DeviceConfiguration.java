package com.energysolution.mvp.data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "device_configuration")
@Data
public class DeviceConfiguration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false, name = "device_id") // Dodane name = "device_id"
    private String deviceId;

    @ManyToOne
    @JoinColumn(name = "iot_device_id", referencedColumnName = "id", nullable = false) // Dodane name = "iot_device_id"
    private IoTDevice device;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String configuration;

    @Column(nullable = false)
    private LocalDateTime creationDate;

    @Column
    private LocalDateTime modificationDate;
}
