package com.akylino.infrastructure.adapter.input;

import com.akylino.domain.dto.CustomerDTO;
import com.akylino.domain.service.BusinessUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/customers")
public class DemoAdapter {
    @Autowired
    private BusinessUseCase businessUseCase;

    @PostMapping("/addCustomer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        log.trace("Entering the Method Create Customer");
        var objectResponse = businessUseCase.generatingCustomer(customerDTO);
        return new ResponseEntity(objectResponse, HttpStatus.OK);
    }
}
