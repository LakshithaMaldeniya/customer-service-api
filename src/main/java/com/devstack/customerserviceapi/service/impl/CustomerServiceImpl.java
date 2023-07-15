package com.devstack.customerserviceapi.service.impl;
import com.devstack.customerserviceapi.dto.core.CustomerDto;
import com.devstack.customerserviceapi.dto.request.RequestCustomerDto;
import com.devstack.customerserviceapi.dto.response.ResponseCustomerDto;
import com.devstack.customerserviceapi.dto.response.paginated.CustomerPaginatedDto;
import com.devstack.customerserviceapi.entity.Customer;
import com.devstack.customerserviceapi.repo.CustomerRepo;
import com.devstack.customerserviceapi.service.CustomerService;
import com.devstack.customerserviceapi.util.mapper.CustomerMapper;
import com.devstack.pos.exception.EntryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {


    private final CustomerRepo customerRepo;

    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerServiceImpl(CustomerRepo customerRepo, CustomerMapper customerMapper) {
        this.customerRepo = customerRepo;
        this.customerMapper = customerMapper;
    }


    @Override
    public ResponseCustomerDto createcustomer(RequestCustomerDto requestCustomerDto) {
        CustomerDto customerDto = new CustomerDto(new Random().nextInt(1001), requestCustomerDto.getName(),
                requestCustomerDto.getAddress(), requestCustomerDto.getSalary());
        Customer savedCustomer = customerRepo.save(customerMapper.toCustomer(customerDto));
        return customerMapper.toResponseCustomerDto(savedCustomer);
    }

    @Override
    public ResponseCustomerDto findCustomer(long id) {
        var selectedCustomer = customerRepo.findById(id);

        if (selectedCustomer.isEmpty()) {
            throw new EntryNotFoundException("Customer Not Found");
        }
        return new ResponseCustomerDto(selectedCustomer.get().getId(), selectedCustomer.get().getName(),
                selectedCustomer.get().getAddress(), selectedCustomer.get().getSalary());
    }

    @Override
    public void deleteCustomer(long id) {
        var selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()) {
            throw new EntryNotFoundException("No Customer Found");
        }
        customerRepo.delete(selectedCustomer.get());
    }

    @Override
    public ResponseCustomerDto UpdateCustomer(RequestCustomerDto requestCustomerDto, long id) {
        var selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isEmpty()) {
            throw new EntryNotFoundException("Customer not Found");
        }
        selectedCustomer.get().setAddress(requestCustomerDto.getAddress());
        selectedCustomer.get().setName(requestCustomerDto.getName());
        selectedCustomer.get().setSalary(requestCustomerDto.getSalary());
        customerRepo.save(selectedCustomer.get());
        return customerMapper.toResponseCustomerDto(selectedCustomer.get());
    }

}
