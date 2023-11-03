package com.akylino.domain.port.out;

import com.akylino.domain.dto.CustomerDTO;
import com.akylino.infrastructure.entity.CustomerEntity;

@FunctionalInterface
public interface GeneratingEntityPort {
    CustomerEntity generatingEntity(CustomerDTO customerDTO);
}
