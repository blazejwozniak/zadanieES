package com.energysolution.mvp.mapper;

import com.energysolution.mvp.data.Address;
import com.energysolution.mvp.dto.AddressDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO toDto(Address address);

    Address toEntity(AddressDTO addressDTO);

    List<AddressDTO> toDtoList(List<Address> addresses);

    List<Address> toEntityList(List<AddressDTO> addressDTOs);
}
