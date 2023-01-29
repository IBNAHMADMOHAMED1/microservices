package io.company.customer.service;

import io.company.customer.dtos.CustomerDto;
import io.company.customer.dtos.FraudCheckResponse;
import io.company.customer.entity.Customer;
import io.company.customer.mapper.CustomerMapper;
import io.company.customer.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CustomerServiceImp implements CustomerService {
    private final CustomerRepo customerRepo;
    private final RestTemplate restTemplate;
    private final String fraudUrl = "http://FRAUD-SERVICE/api/v1";
    private final CustomerMapper customerMapper;

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = Customer.builder()
                .name(customerDto.getName())
                .email(customerDto.getEmail())
                .password(customerDto.getPassword())
                .build();
      CustomerDto newCustomer = customerMapper.customerToCustomerDto(customerRepo.saveAndFlush(customer));
      FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
              fraudUrl + "/fraud-check/" + customer.getId(),
                FraudCheckResponse.class
        );


        if (fraudCheckResponse != null && fraudCheckResponse.getIsFraud()) {
            throw new IllegalStateException("Fraud check failed");
        }
        return newCustomer;
    }

    @Override
    public Customer findByEmail(String email) {
        return null;
    }
}

