package com.example.bank_app.controller;

import com.example.bank_app.dto.ReportsDto;
import com.example.bank_app.dto.request.ReportsRequest;
import com.example.bank_app.service.ReportsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/reports")
public class ReportsController {

    private final ReportsService reportsService;

    @GetMapping(value = "/reportsList")
    public List<ReportsDto> getReportsInfo() {
        return reportsService.getAll();
    }

    @GetMapping(value = "/getReportsByReportsId/{reportsId}")
    public ReportsDto getEmployeesByEmployeeId(@PathVariable(value = "reportsId") Long reportsId) {
        return reportsService.getReportsByReportsId(reportsId);
    }

    @PostMapping(value = "/saveReports")
    public void saveReports(@RequestBody ReportsRequest reportsRequest) {
        reportsService.saveReports(reportsRequest);
    }

    @PostMapping(value = "/updateReports")
    public void updateReports(@RequestBody ReportsRequest reportsRequest) {
        reportsService.updateReport(reportsRequest);
    }

    @DeleteMapping(value = "/deleteReports/{reportsId}")
    public void deleteById(@PathVariable(value = "reportsId") Long reportsId) {
        reportsService.deleteById(reportsId);
    }
}

