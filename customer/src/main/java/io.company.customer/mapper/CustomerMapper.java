package io.company.customer.mapper;

import io.company.customer.dtos.CustomerDto;
import io.company.customer.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper( CustomerMapper.class );
    CustomerDto customerToCustomerDto(Customer customer);

}
