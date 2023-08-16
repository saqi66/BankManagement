package com.example.bank_app.controller;


import com.example.bank_app.dto.CustomerDto;
import com.example.bank_app.dto.request.CustomerRequest;
import com.example.bank_app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping(value = "/customerList")
    public List<CustomerDto> getCustomerInfo() {
        return customerService.getAll();
    }

    @GetMapping(value = "/getCustomerByCustomerId/{customerId}")
    public CustomerDto getCustomerByCustomerId(@PathVariable(value = "customerId") Long customerId) {
        return customerService.getCustomerByCustomerId(customerId);
    }

    @PostMapping(value = "/saveCustomer")
    public void saveCustomer(@RequestBody CustomerRequest customerRequest) {
        customerService.saveCustomer(customerRequest);
    }

    @PostMapping(value = "/updateCustomer")
    public void updateCustomer(@RequestBody CustomerRequest customerRequest) {
        customerService.updateCustomer(customerRequest);
    }

    @DeleteMapping(value = "/deleteCustomer/{customerId}")
    public void deleteById(@PathVariable(value = "customerId") Long customerId) {
        customerService.deleteById(customerId);


    }
}