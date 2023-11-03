package com.akylino.domain.port.out;


import com.akylino.infrastructure.entity.CustomerEntity;


public interface DynamoDbPort {
    void persistence(CustomerEntity entity);
}
