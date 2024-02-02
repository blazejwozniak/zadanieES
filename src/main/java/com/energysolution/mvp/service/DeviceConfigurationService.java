package com.energysolution.mvp.service;

import com.energysolution.mvp.data.DeviceConfiguration;
import com.energysolution.mvp.data.IoTDevice;
import com.energysolution.mvp.dto.DeviceConfigurationDTO;
import com.energysolution.mvp.mapper.DeviceConfigurationMapper;
import com.energysolution.mvp.repository.DeviceConfigurationRepository;
import com.energysolution.mvp.repository.IoTDeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeviceConfigurationService {

    private final DeviceConfigurationRepository deviceConfigurationRepository;
    private final DeviceConfigurationMapper deviceConfigurationMapper;
    private final IoTDeviceRepository ioTDeviceRepository;

    @Autowired
    public DeviceConfigurationService(DeviceConfigurationRepository deviceConfigurationRepository,
                                      IoTDeviceRepository ioTDeviceRepository,
                                      DeviceConfigurationMapper deviceConfigurationMapper) {
        this.deviceConfigurationRepository = deviceConfigurationRepository;
        this.deviceConfigurationMapper = deviceConfigurationMapper;
        this.ioTDeviceRepository = ioTDeviceRepository;
    }

//    public DeviceConfigurationDTO createConfiguration(DeviceConfigurationDTO configurationDTO) {
//        DeviceConfiguration configuration = deviceConfigurationMapper.toEntity(configurationDTO);
//        DeviceConfiguration savedConfiguration = deviceConfigurationRepository.save(configuration);
//        return deviceConfigurationMapper.toDto(savedConfiguration);
//    }

    public DeviceConfigurationDTO createConfiguration(DeviceConfigurationDTO configurationDTO) {
        // Mapowanie DTO na encję
        DeviceConfiguration configuration = deviceConfigurationMapper.toEntity(configurationDTO);

        // Pobierz obiekt IoTDevice na podstawie deviceId
        IoTDevice ioTDevice = ioTDeviceRepository.findByDeviceId(configurationDTO.deviceId())
                .orElseThrow(() -> new EntityNotFoundException("IoTDevice not found for deviceId: " + configurationDTO.deviceId()));

        // Ustaw encję DeviceConfiguration
        configuration.setDevice(ioTDevice);

        // Zapisz w bazie danych
        DeviceConfiguration savedConfiguration = deviceConfigurationRepository.save(configuration);

        // Mapowanie z powrotem na DTO
        return deviceConfigurationMapper.toDto(savedConfiguration);
    }

    public DeviceConfigurationDTO getConfiguration(String deviceId) {
        DeviceConfiguration configuration = deviceConfigurationRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new EntityNotFoundException("Configuration not found for device: " + deviceId));
        return deviceConfigurationMapper.toDto(configuration);
    }

    public DeviceConfigurationDTO updateConfiguration(Long configurationId, DeviceConfigurationDTO newConfigurationDTO) {
        DeviceConfiguration existingConfiguration = deviceConfigurationRepository.findById(configurationId)
                .orElseThrow(() -> new EntityNotFoundException("Configuration not found for id: " + configurationId));

        existingConfiguration.setConfiguration(newConfigurationDTO.configuration());
        existingConfiguration.setModificationDate(newConfigurationDTO.modificationDate());

        DeviceConfiguration updatedConfiguration = deviceConfigurationRepository.save(existingConfiguration);
        return deviceConfigurationMapper.toDto(updatedConfiguration);
    }

    public void deleteConfiguration(Long configurationId) {
        DeviceConfiguration configuration = deviceConfigurationRepository.findById(configurationId)
                .orElseThrow(() -> new EntityNotFoundException("Configuration not found for configurationId: " + configurationId));
        deviceConfigurationRepository.delete(configuration);
    }

    public List<DeviceConfigurationDTO> getAllConfigurations() {
        List<DeviceConfiguration> configurations = deviceConfigurationRepository.findAll();
        return configurations.stream()
                .map(deviceConfigurationMapper::toDto)
                .collect(Collectors.toList());
    }
}

