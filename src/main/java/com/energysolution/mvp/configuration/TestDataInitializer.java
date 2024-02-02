package com.energysolution.mvp.configuration;

import com.energysolution.mvp.data.DeviceConfiguration;
import com.energysolution.mvp.data.IoTDevice;
import com.energysolution.mvp.dto.DeviceConfigurationDTO;
import com.energysolution.mvp.dto.IoTDeviceDTO;
import com.energysolution.mvp.mapper.IoTDeviceMapper;
import com.energysolution.mvp.service.DeviceConfigurationService;
import com.energysolution.mvp.service.IoTDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class TestDataInitializer {

    private final IoTDeviceService ioTDeviceService;
    private final DeviceConfigurationService deviceConfigurationService;

    @Autowired
    public TestDataInitializer(IoTDeviceService ioTDeviceService, DeviceConfigurationService deviceConfigurationService) {
        this.ioTDeviceService = ioTDeviceService;
        this.deviceConfigurationService = deviceConfigurationService;
    }

    @Bean
    public CommandLineRunner initTestData() {
        return args -> {
            // Dodaj przykładowe urządzenia IoT
            IoTDeviceDTO deviceDTO1 = new IoTDeviceDTO("device1", LocalDateTime.now(), null, null, null, null);
            ioTDeviceService.createDevice(deviceDTO1);

            IoTDeviceDTO deviceDTO2 = new IoTDeviceDTO("device2", LocalDateTime.now(), null, null, null, null);
            ioTDeviceService.createDevice(deviceDTO2);

            // Pobierz zapisane obiekty IoTDevice
            IoTDeviceDTO device1 = ioTDeviceService.getDevice("device1");
            IoTDeviceDTO device2 = ioTDeviceService.getDevice("device2");

            // Dodaj przykładowe konfiguracje urządzeń IoT
            DeviceConfigurationDTO configDTO1 = new DeviceConfigurationDTO("device1",
                    "{\"param1\": \"value1\", \"param2\": \"value2\"}", LocalDateTime.now(), null);
            deviceConfigurationService.createConfiguration(configDTO1);

            DeviceConfigurationDTO configDTO2 = new DeviceConfigurationDTO("device2",
                    "{\"param3\": \"value3\", \"param4\": \"value4\"}", LocalDateTime.now(), null);
            deviceConfigurationService.createConfiguration(configDTO2);
        };
    }
}


