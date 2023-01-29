package io.company.customer.service;

import io.company.customer.dtos.CustomerDto;
import io.company.customer.entity.Customer;

public interface CustomerService {
    CustomerDto save(CustomerDto customerDto);
    Customer findByEmail(String email);
}
