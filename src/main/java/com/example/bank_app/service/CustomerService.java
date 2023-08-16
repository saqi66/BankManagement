package com.example.bank_app.service;

import com.example.bank_app.dto.CustomerDto;
import com.example.bank_app.dto.request.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CustomerService {
    CustomerDto  getCustomerByCustomerId(Long customerId);
    void saveCustomer(CustomerRequest customerRequest);

    void updateCustomer(CustomerRequest customerRequest);

    List<CustomerDto> getAll();
    void deleteById(Long customerId);
}
