package io.company.fraud.service;

import io.company.fraud.entity.FraudCheckHistory;
import io.company.fraud.repository.FraudRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudServcieImp implements FraudServcie {
    private final FraudRepo fraudRepo;

    @Override
    public Boolean isFraudentCustomer(Long customerId) {
        fraudRepo.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraud(false)
                        .createdAT(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
