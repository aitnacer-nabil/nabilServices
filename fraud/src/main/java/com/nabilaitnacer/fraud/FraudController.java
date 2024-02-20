package com.nabilaitnacer.fraud;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    final FraudCheckService fraudCheckService;

    @GetMapping("{customerId}")
    public FraudCheckResponse checkFraud(@PathVariable("customerId") Long customerId){
        log.info("Checking fraud for customer: {}", customerId);
        boolean isFraud = fraudCheckService.isFraudCustomer(customerId);
        return new FraudCheckResponse(isFraud);
    }
}
