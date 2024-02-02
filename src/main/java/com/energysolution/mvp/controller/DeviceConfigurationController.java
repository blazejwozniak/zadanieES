package com.energysolution.mvp.controller;

import com.energysolution.mvp.data.DeviceConfiguration;
import com.energysolution.mvp.dto.DeviceConfigurationDTO;
import com.energysolution.mvp.mapper.DeviceConfigurationMapper;
import com.energysolution.mvp.service.DeviceConfigurationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/configurations")
public class DeviceConfigurationController {

    private final DeviceConfigurationService deviceConfigurationService;
    private final DeviceConfigurationMapper deviceConfigurationMapper;

    @Autowired
    public DeviceConfigurationController(DeviceConfigurationService deviceConfigurationService, DeviceConfigurationMapper deviceConfigurationMapper) {
        this.deviceConfigurationService = deviceConfigurationService;
        this.deviceConfigurationMapper = deviceConfigurationMapper;
    }

    @PostMapping
    public ResponseEntity<DeviceConfigurationDTO> createConfiguration(@Valid @RequestBody DeviceConfigurationDTO configurationDTO) {
        DeviceConfigurationDTO createdConfiguration = deviceConfigurationService.createConfiguration(configurationDTO);
        return new ResponseEntity<>(createdConfiguration, HttpStatus.CREATED);
    }

    @GetMapping("/{configurationId}")
    public ResponseEntity<DeviceConfigurationDTO> getConfiguration(@PathVariable String configurationId) {
        DeviceConfigurationDTO configuration = deviceConfigurationService.getConfiguration(configurationId);
        return ResponseEntity.ok(configuration);
    }

    @PatchMapping("/{configurationId}")
    public ResponseEntity<DeviceConfigurationDTO> updateConfiguration(
            @PathVariable Long configurationId, @RequestBody DeviceConfigurationDTO configurationDTO) {
        DeviceConfigurationDTO updatedConfiguration = deviceConfigurationService.updateConfiguration(configurationId, configurationDTO);
        return new ResponseEntity<>(updatedConfiguration, HttpStatus.OK);
    }

    @DeleteMapping("/{configurationId}")
    public ResponseEntity<Void> deleteConfiguration(@PathVariable Long configurationId) {
        deviceConfigurationService.deleteConfiguration(configurationId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<DeviceConfigurationDTO>> getAllConfigurations() {
        List<DeviceConfigurationDTO> configurations = deviceConfigurationService.getAllConfigurations();
        return new ResponseEntity<>(configurations, HttpStatus.OK);
    }

}
