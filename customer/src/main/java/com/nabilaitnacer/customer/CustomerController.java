package com.nabilaitnacer.customer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@Slf4j
public record CustomerController (CustomerService customerService){

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequestRegisterDto customerRequest){
       log.info("Registering customer: {}", customerRequest);
       customerService.registerCustomer(customerRequest);
    }
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getCustomers(){
        log.info("Getting customers");
        return ResponseEntity.ok(customerService.getCustomers());
    }
}
