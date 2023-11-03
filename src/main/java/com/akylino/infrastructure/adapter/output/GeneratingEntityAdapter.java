package com.akylino.infrastructure.adapter.output;

import com.akylino.domain.dto.CustomerDTO;
import com.akylino.domain.port.out.GeneratingEntityPort;
import com.akylino.infrastructure.entity.CustomerEntity;
import com.akylino.infrastructure.mapper.Mapper;
import org.springframework.stereotype.Component;

@Component
public class GeneratingEntityAdapter implements GeneratingEntityPort {
    private final Mapper mapper;

    public GeneratingEntityAdapter(Mapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public CustomerEntity generatingEntity(CustomerDTO customerDTO) {
        return mapper.convertObjectDtoToEntity(customerDTO);
    }
}
