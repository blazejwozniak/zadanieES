package com.energysolution.mvp.service;

import com.energysolution.mvp.data.IoTDevice;
import com.energysolution.mvp.dto.IoTDeviceDTO;
import com.energysolution.mvp.mapper.IoTDeviceMapper;
import com.energysolution.mvp.repository.IoTDeviceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IoTDeviceService {

    private final IoTDeviceRepository ioTDeviceRepository;
    private final IoTDeviceMapper ioTDeviceMapper;

    @Autowired
    public IoTDeviceService(IoTDeviceRepository ioTDeviceRepository, IoTDeviceMapper ioTDeviceMapper) {
        this.ioTDeviceRepository = ioTDeviceRepository;
        this.ioTDeviceMapper = ioTDeviceMapper;
    }

    public IoTDeviceDTO createDevice(IoTDeviceDTO deviceDTO) {
        IoTDevice device = ioTDeviceMapper.toEntity(deviceDTO);
        IoTDevice savedDevice = ioTDeviceRepository.save(device);
        return ioTDeviceMapper.toDto(savedDevice);
    }

    public IoTDeviceDTO getDevice(String deviceId) {
        IoTDevice device = ioTDeviceRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new EntityNotFoundException("Device not found: " + deviceId));
        return ioTDeviceMapper.toDto(device);
    }

    public List<IoTDeviceDTO> getAllDevices() {
        List<IoTDevice> devices = ioTDeviceRepository.findAll();
        return devices.stream()
                .map(ioTDeviceMapper::toDto)
                .collect(Collectors.toList());
    }
}