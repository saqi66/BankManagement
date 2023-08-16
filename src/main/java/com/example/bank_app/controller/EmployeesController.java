package com.example.bank_app.controller;

import com.example.bank_app.dto.EmployeesDto;
import com.example.bank_app.dto.request.EmployeesRequest;
import com.example.bank_app.service.EmployeesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/employees")
public class EmployeesController {

    private final EmployeesService employeesService;

    @GetMapping(value = "/emplyeesList")
    public List<EmployeesDto> getEmplyeesInfo() {
        return employeesService.getAll();
    }

    @GetMapping(value = "/getEmployeesByEmployeeId/{employeeId}")
    public EmployeesDto getEmployeesByEmployeeId(@PathVariable(value = "employeeId") Long employeeId) {
        return employeesService.getEmployeesByEmployeeId(employeeId);
    }

    @PostMapping(value = "/saveEmployees")
    public void saveEmployees(@RequestBody EmployeesRequest employeesRequest) {
        employeesService.saveEmployees(employeesRequest);
    }

    @PostMapping(value = "/updateEmployees")
    public void updateEmployees(@RequestBody EmployeesRequest employeesRequest) {
        employeesService.updateEmployees(employeesRequest);
    }
    @DeleteMapping(value = "/deleteEmployees/{employeeId}")
    public void deleteById(@PathVariable(value = "employeeId") Long employeeId) {
        employeesService.deleteById(employeeId);
}
}