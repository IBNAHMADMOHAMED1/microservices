package io.company.customer.service;

import io.company.customer.entity.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImp implements CustomerService {

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public Customer findByEmail(String email) {
        return null;
    }
}

