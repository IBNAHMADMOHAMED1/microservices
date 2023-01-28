package io.company.customer.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
@Data
public class CustomerDto {
    private Long id;
    private String name;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
}
