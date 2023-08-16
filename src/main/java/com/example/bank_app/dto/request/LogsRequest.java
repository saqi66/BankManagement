package com.example.bank_app.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogsRequest {
    private Long logsId;
    private Long transId;

    private Date loginDate;
    private String loginTime;
}
