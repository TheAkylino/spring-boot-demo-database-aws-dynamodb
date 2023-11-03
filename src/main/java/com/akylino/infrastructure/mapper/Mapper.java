package com.akylino.infrastructure.mapper;

import com.akylino.domain.dto.CustomerDTO;
import com.akylino.infrastructure.entity.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

@Service
public class Mapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public CustomerEntity convertObjectDtoToEntity(CustomerDTO customerDto) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper.map(customerDto, CustomerEntity.class);
    }
}
