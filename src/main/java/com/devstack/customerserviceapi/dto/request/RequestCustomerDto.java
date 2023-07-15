package com.devstack.customerserviceapi.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestCustomerDto {
    private String name;
    private String address;
    private double salary;

}
