package com.example.bank_app.service.impl;

import com.example.bank_app.dto.EmployeesDto;
import com.example.bank_app.dto.request.EmployeesRequest;
import com.example.bank_app.model.Employees;
import com.example.bank_app.repository.EmployeesRepository;
import com.example.bank_app.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesRepository employeesRepository;


    @Override
    public EmployeesDto getEmployeesByEmployeeId(Long employeeId) {
        Employees employees = employeesRepository.getEmployeesByEmployeeId(employeeId);
        return EmployeesDto.builder()
                .fname(employees.getFname())
                .lname(employees.getLname())
                .username(employees.getUsername())
                .build();
    }

    @Override
    public void saveEmployees(EmployeesRequest employeesRequest) {
        Employees employees = Employees.builder()
                .fname(employeesRequest.getFname())
                .lname(employeesRequest.getLname())
                .username(employeesRequest.getUsername())
                .adress(employeesRequest.getAdress())
                .contactAdd(employeesRequest.getContactAdd())
                .password(employeesRequest.getPassword())
                .build();

        employeesRepository.save(employees);
    }

    @Override
    public void updateEmployees(EmployeesRequest employeesRequest) {
        Employees employees = Employees.builder()
                .employeeId(employeesRequest.getEmployeeId())
                .fname(employeesRequest.getFname())
                .lname(employeesRequest.getLname())
                .adress(employeesRequest.getAdress())
                .contactAdd(employeesRequest.getContactAdd())
                .username(employeesRequest.getUsername())
                .password(employeesRequest.getPassword())
                .build();

        employeesRepository.save(employees);
    }

    @Override
    public List<EmployeesDto> getAll() {
        List<Employees> employees = employeesRepository.findAll();
        List<EmployeesDto> employeesDtos = new ArrayList<>();

        for (Employees employee : employees) {
            EmployeesDto employeesDto = EmployeesDto.builder()
                    .fname(employee.getFname())
                    .lname(employee.getLname())
                    .username(employee.getUsername())
                    .build();

            employeesDtos.add(employeesDto);
        }

        return employeesDtos;
    }

    @Override
    public void deleteById(Long employeeId) {
        Employees employees = employeesRepository.getEmployeesByEmployeeId(employeeId);
        if (employees.getLname() == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            employeesRepository.deleteById(employeeId);
        }
    }
}