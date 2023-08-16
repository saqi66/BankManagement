package com.example.bank_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesRequest {

    private Long employeeId;
    private String fname;
    private String lname;
    private String adress;
    private String contactAdd;
    private String username;
    private String password;
}
