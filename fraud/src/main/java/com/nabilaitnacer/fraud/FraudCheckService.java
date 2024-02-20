package com.nabilaitnacer.fraud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {
    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    public boolean isFraudCustomer(Long customerId) {
        registerFraudCheck(customerId);
        return false;
    }
private void registerFraudCheck(Long customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraud(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
    }
}
