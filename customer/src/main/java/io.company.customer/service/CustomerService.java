package io.company.customer.service;

import io.company.customer.entity.Customer;

public interface CustomerService {
    Customer save(Customer customer);
    Customer findByEmail(String email);
}
