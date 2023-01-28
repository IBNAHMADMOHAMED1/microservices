package io.company.customer.contoller;


import io.company.customer.dtos.CustomerDto;
import io.company.customer.entity.Customer;
import io.company.customer.mapper.CustomerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
public class ApiCustomerController {

    private final CustomerMapper customerMapper;

    @GetMapping()
    public ResponseEntity<CustomerDto> getCustomer() {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("John");
        customer.setEmail("hh");
        customer.setPassword("123");
        return ResponseEntity.ok(customerMapper.customerToCustomerDto(customer));
    }

    @PostMapping()
    public ResponseEntity<CustomerDto> postCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setPassword(customerDto.getPassword());
        return ResponseEntity.ok(customerMapper.customerToCustomerDto(customer));
    }
}
