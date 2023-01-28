package io.company.customer.entity;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

    private Long id;
    private String name;
    private String email;
    private String password;

}
