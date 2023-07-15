package com.devstack.customerserviceapi.service;

import com.devstack.customerserviceapi.StandardResponseModel;
import com.devstack.customerserviceapi.dto.request.RequestCustomerDto;
import com.devstack.customerserviceapi.dto.response.ResponseCustomerDto;
import com.devstack.customerserviceapi.dto.response.paginated.CustomerPaginatedDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CustomerService {
    public ResponseCustomerDto createcustomer(RequestCustomerDto requestCustomerDto);

    public ResponseCustomerDto findCustomer(long id);

    public void deleteCustomer(long id);

    public ResponseCustomerDto UpdateCustomer(RequestCustomerDto requestCustomerDto, long id);



}
