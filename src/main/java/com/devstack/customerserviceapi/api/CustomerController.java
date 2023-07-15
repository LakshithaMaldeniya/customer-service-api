package com.devstack.customerserviceapi.api;

import com.devstack.customerserviceapi.StandardResponseModel;
import com.devstack.customerserviceapi.dto.request.RequestCustomerDto;
import com.devstack.customerserviceapi.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @PostMapping
    public ResponseEntity<StandardResponseModel> createCustomer(@RequestBody RequestCustomerDto requestCustomerDto) {
        return new ResponseEntity<>(new StandardResponseModel(201, "Customer Saved", customerService.createcustomer(requestCustomerDto)),
                HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponseModel> findCustomer(@PathVariable long id) {
        return new ResponseEntity<>(new StandardResponseModel(200, "Customer found", customerService.findCustomer(id)),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponseModel> deleteCustomer(@PathVariable long id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(new StandardResponseModel(200, "Customer deleted", ""),
                HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponseModel> UpdateCustomer(@RequestBody RequestCustomerDto requestCustomerDto,
                                                                @PathVariable long id) {
        return new ResponseEntity<>(new StandardResponseModel(201, "Customer Updated",
                customerService.UpdateCustomer(requestCustomerDto,id)),
                HttpStatus.CREATED);
    }
}
