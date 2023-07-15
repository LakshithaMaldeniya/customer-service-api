package com.devstack.customerserviceapi.util.mapper;

import com.devstack.customerserviceapi.dto.core.CustomerDto;
import com.devstack.customerserviceapi.dto.request.RequestCustomerDto;
import com.devstack.customerserviceapi.dto.response.ResponseCustomerDto;
import com.devstack.customerserviceapi.entity.Customer;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CustomerMapper {
    Customer toCustomer(CustomerDto customerDto);

    ResponseCustomerDto toResponseCustomerDto(Customer customer);


}
