package com.akylino.domain.service;

import com.akylino.domain.dto.CustomerDTO;
import com.akylino.domain.port.out.DynamoDbPort;
import com.akylino.domain.port.out.GeneratingEntityPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BusinessUseCase {

    private final DynamoDbPort dynamoDbPort;
    private final GeneratingEntityPort generatingEntityPort;

    public BusinessUseCase(DynamoDbPort dynamoDbPort, GeneratingEntityPort generatingEntityPort) {
        this.dynamoDbPort = dynamoDbPort;
        this.generatingEntityPort = generatingEntityPort;
    }


    public CustomerDTO generatingCustomer(CustomerDTO customerDTO) {
        log.trace("Entering the Method Generating Customer");
        var entity = generatingEntityPort.generatingEntity(customerDTO);
        dynamoDbPort.persistence(entity);
        return customerDTO;
    }
}
