package com.devstack.customerserviceapi.dto.core;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    private long id;
    private String name;
    private String address;
    private double salary;
}
