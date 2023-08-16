package com.example.bank_app.service;

import com.example.bank_app.dto.EmployeesDto;
import com.example.bank_app.dto.request.EmployeesRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface EmployeesService {
    EmployeesDto getEmployeesByEmployeeId(Long employeeId);

    void saveEmployees(EmployeesRequest employeesRequest);

    void updateEmployees(EmployeesRequest employeesRequest);

    List<EmployeesDto> getAll();
    void deleteById(Long employeeId);
}
