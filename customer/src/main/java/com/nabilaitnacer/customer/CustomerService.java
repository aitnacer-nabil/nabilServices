package com.nabilaitnacer.customer;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    final CustomerRepository customerRepository;
    final RestTemplate restTemplate;

    public void registerCustomer(CustomerRequestRegisterDto customerRequest) {
        Customer customer = Customer.builder()
                .email(customerRequest.getEmail())
                .name(customerRequest.getName())
                .lastname(customerRequest.getLastname())
                .build();
        //TODO validation
        //todo check if email is not taken
        //todo check if fraudster
        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8089/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());
        //todo send notification
        if (fraudCheckResponse.isFraud()){
            throw  new IllegalStateException("Fraudster");
        }


    }

    public List<CustomerDto> getCustomers() {
        return customerRepository.findAll().stream()
                .map(customer -> new CustomerDto(customer.getId(), customer.getName(), customer.getEmail(), customer.getLastname()))
                .toList();
    }
}
