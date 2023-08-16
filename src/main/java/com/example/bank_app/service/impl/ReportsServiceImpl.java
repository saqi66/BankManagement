package com.example.bank_app.service.impl;

import com.example.bank_app.dto.ReportsDto;
import com.example.bank_app.dto.request.ReportsRequest;
import com.example.bank_app.model.Reports;
import com.example.bank_app.repository.ReportsRepository;
import com.example.bank_app.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReportsServiceImpl implements ReportsService {

    private final ReportsRepository reportRepository;

    @Override
    public ReportsDto getReportsByReportsId(Long reportsId) {
        Reports reports = reportRepository.getReportsByReportId(reportsId);
        return ReportsDto.builder()
                .reportName(reports.getReportName())
                .reportDate(reports.getReportDate())
                .build();
    }

    @Override
    public void saveReports(ReportsRequest reportRequest) {
        Reports report = Reports.builder()
                .reportName(reportRequest.getReportName())
                .reportDate(reportRequest.getReportDate())
                .accId(reportRequest.getAccId())
                .transId(reportRequest.getTransId())
                .logsId(reportRequest.getLogsId())
                .build();

        reportRepository.save(report);
    }

    @Override
    public void updateReport(ReportsRequest reportRequest) {
        Reports report = Reports.builder()
                .reportId(reportRequest.getReportId())
                .reportName(reportRequest.getReportName())
                .reportDate(reportRequest.getReportDate())
                .accId(reportRequest.getAccId())
                .transId(reportRequest.getTransId())
                .logsId(reportRequest.getLogsId())
                .build();

        reportRepository.save(report);
    }

    @Override
    public List<ReportsDto> getAll() {
        List<Reports> reports = reportRepository.findAll();
        List<ReportsDto> reportDtos = new ArrayList<>();

        for (Reports reports1 : reports) {
            ReportsDto reportDto = ReportsDto.builder()
                    .reportName(reports1.getReportName())
                    .reportDate(reports1.getReportDate())
                    .build();

            reportDtos.add(reportDto);
        }

        return reportDtos;
    }

    @Override
    public void deleteById(Long reportsId) {
        Reports reports = reportRepository.getReportsByReportId(reportsId);
        if (reports.getReportName() == (null)){
            throw new RuntimeException("bele id yoxdur");

        }else {
            reportRepository.deleteById(reportsId);
        }
    }
}
