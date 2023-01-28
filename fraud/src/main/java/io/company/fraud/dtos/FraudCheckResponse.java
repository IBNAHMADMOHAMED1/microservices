package io.company.fraud.dtos;

import lombok.Data;

@Data
public class FraudCheckResponse {
    private Long customerId;
    private Boolean isFraud;

}
