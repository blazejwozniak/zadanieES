package com.energysolution.mvp.mapper;

import com.energysolution.mvp.data.DeviceConfiguration;
import com.energysolution.mvp.dto.DeviceConfigurationDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeviceConfigurationMapper {
    DeviceConfigurationDTO toDto(DeviceConfiguration deviceConfiguration);
    DeviceConfiguration toEntity(DeviceConfigurationDTO deviceConfigurationDTO);
    List<DeviceConfigurationDTO> toDtoList(List<DeviceConfiguration> deviceConfigurationList);
    List<DeviceConfiguration> toEntityList(List<DeviceConfigurationDTO> deviceConfigurationDTOS);
}
