package io.company.customer.controller;


import io.company.customer.dtos.CustomerDto;
import io.company.customer.entity.Customer;
import io.company.customer.mapper.CustomerMapper;
import io.company.customer.service.CustomerService;
import io.company.customer.service.CustomerServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class ApiCustomerController {

    private final CustomerMapper customerMapper;
    private final CustomerServiceImp customerService;

    @GetMapping()
    public ResponseEntity<CustomerDto> getCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John");
        customer.setEmail("hh");
        customer.setPassword("123");
        return ResponseEntity.ok(customerMapper.customerToCustomerDto(customer));
    }

    @PostMapping("/save")
    public ResponseEntity<CustomerDto> postCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.ok(customerService.save(customerDto));
    }
}
