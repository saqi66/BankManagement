package com.example.bank_app.repository;

import com.example.bank_app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer getCustomerByCustomerId(Long customerId);
}
