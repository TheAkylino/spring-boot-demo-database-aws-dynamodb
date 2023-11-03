package com.akylino.infrastructure.adapter.output;

import com.akylino.domain.port.out.DynamoDbPort;
import com.akylino.infrastructure.entity.CustomerEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class DynamoDbAdapter implements DynamoDbPort {

    @Autowired private DynamoDBMapper dynamoDBMapper;

    @Override
    public void persistence(CustomerEntity entity) {
        log.trace("Entering the Method Persistence");
        dynamoDBMapper.save(entity);
    }
}
