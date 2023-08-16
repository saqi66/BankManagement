package com.example.bank_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionsRequest {
    private Long transId;
    private Long employeeId;
    private Long customerId;
    private String name;
}
