package com.example.bank_app.service;

import com.example.bank_app.dto.ReportsDto;
import com.example.bank_app.dto.request.ReportsRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportsService {
    ReportsDto getReportsByReportsId(Long reportsId);

    void saveReports(ReportsRequest reportsRequest);

    void updateReport(ReportsRequest reportsRequest);

    List<ReportsDto> getAll();

    void deleteById(Long reportsId);

}
