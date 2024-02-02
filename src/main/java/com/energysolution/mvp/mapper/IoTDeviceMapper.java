package com.energysolution.mvp.mapper;

import com.energysolution.mvp.data.IoTDevice;
import com.energysolution.mvp.dto.IoTDeviceDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = AddressMapper.class)
public interface IoTDeviceMapper {

    IoTDeviceDTO toDto(IoTDevice device);

    IoTDevice toEntity(IoTDeviceDTO deviceDTO);

    List<IoTDeviceDTO> toDtoList(List<IoTDevice> devices);

    List<IoTDevice> toEntityList(List<IoTDeviceDTO> deviceDTOs);
}