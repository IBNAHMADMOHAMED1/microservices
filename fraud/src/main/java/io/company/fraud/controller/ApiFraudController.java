package io.company.fraud.controller;

import io.company.fraud.dtos.FraudCheckResponse;
import io.company.fraud.service.FraudServcieImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fraud-check")
@RequiredArgsConstructor
public class ApiFraudController {
    private final FraudServcieImp fraudServcie;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse checkFraud(@PathVariable("customerId") Long customerId) {
        Boolean isFraud = fraudServcie.isFraudentCustomer(customerId);
        FraudCheckResponse fraudCheckResponse = new FraudCheckResponse();
        fraudCheckResponse.setCustomerId(customerId);
        fraudCheckResponse.setIsFraud(isFraud);
        return fraudCheckResponse;

    }
}
