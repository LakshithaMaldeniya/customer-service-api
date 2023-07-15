package com.devstack.customerserviceapi.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseCustomerDto {

    private long id;
    private String name;
    private String address;
    private double salary;
}
