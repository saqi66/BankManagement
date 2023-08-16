package com.example.bank_app.service.impl;

import com.example.bank_app.dto.CustomerDto;
import com.example.bank_app.dto.request.CustomerRequest;
import com.example.bank_app.model.Customer;
import com.example.bank_app.repository.CustomerRepository;
import com.example.bank_app.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomerDto getCustomerByCustomerId(Long customerId) {
        Customer customer = customerRepository.getCustomerByCustomerId(customerId);
        return CustomerDto.builder()
                .fname(customer.getFname())
                .lname(customer.getLname())
                .username(customer.getUsername())
                .build();
    }

    @Override
    public void saveCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .fname(customerRequest.getFname())
                .lname(customerRequest.getLname())
                .username(customerRequest.getUsername())
                .adress(customerRequest.getAdress())
                .contactAdd(customerRequest.getContactAdd())
                .password(customerRequest.getPassword()).build();

        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(CustomerRequest customerRequest) {
        Customer customer = Customer.builder()
                .customerId(customerRequest.getCustomerId())
                .fname(customerRequest.getFname())
                .lname(customerRequest.getLname())
                .username(customerRequest.getUsername())
                .adress(customerRequest.getAdress())
                .contactAdd(customerRequest.getContactAdd())
                .password(customerRequest.getPassword()).build();

        customerRepository.save(customer);
    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> customers = customerRepository.findAll();
        List<CustomerDto> customerDtos = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerDto customerDto = CustomerDto.builder()
                    .fname(customer.getFname())
                    .lname(customer.getLname())
                    .username(customer.getUsername())
                    .build();

            customerDtos.add(customerDto);
        }

        return customerDtos;
    }

    @Override
    public void deleteById(Long customerId) {
        Customer customer = customerRepository.getCustomerByCustomerId(customerId);

        if (customer.getLname() == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            customerRepository.deleteById(customerId);
        }
    }
}