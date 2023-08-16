package com.example.bank_app.repository;

import com.example.bank_app.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    Employees getEmployeesByEmployeeId(Long employeeId);}
