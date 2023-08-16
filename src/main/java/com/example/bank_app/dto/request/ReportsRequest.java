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

public class ReportsRequest {
    private Long reportId;
    private Long accId;
    private Long logsId;
    private Long transId;
    private String reportName;
    private Date reportDate;



}



