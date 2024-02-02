package com.energysolution.mvp.controller;

import com.energysolution.mvp.data.IoTDevice;
import com.energysolution.mvp.dto.IoTDeviceDTO;
import com.energysolution.mvp.mapper.IoTDeviceMapper;
import com.energysolution.mvp.service.IoTDeviceService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
@Validated
public class IoTDeviceController {

    private final IoTDeviceService ioTDeviceService;

    @Autowired
    public IoTDeviceController(IoTDeviceService ioTDeviceService) {
        this.ioTDeviceService = ioTDeviceService;
    }

    @PostMapping
    public ResponseEntity<IoTDeviceDTO> createDevice(@Valid @RequestBody IoTDeviceDTO deviceDTO) {
        IoTDeviceDTO createdDeviceDTO = ioTDeviceService.createDevice(deviceDTO);
        return new ResponseEntity<>(createdDeviceDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<IoTDeviceDTO> getDevice(@PathVariable String deviceId) {
        IoTDeviceDTO deviceDTO = ioTDeviceService.getDevice(deviceId);
        return ResponseEntity.ok(deviceDTO);
    }

    @GetMapping
    public ResponseEntity<List<IoTDeviceDTO>> getAllDevices() {
        List<IoTDeviceDTO> devicesDTO = ioTDeviceService.getAllDevices();
        return new ResponseEntity<>(devicesDTO, HttpStatus.OK);
    }
}

