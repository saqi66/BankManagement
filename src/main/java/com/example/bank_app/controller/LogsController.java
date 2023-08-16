package com.example.bank_app.controller;

import com.example.bank_app.dto.LogsDto;
import com.example.bank_app.dto.request.LogsRequest;
import com.example.bank_app.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/logs")
public class LogsController {

    private  final LogsService logsService;

    @GetMapping(value = "/logsList")
    public List<LogsDto> getLogsInfo() {
        return logsService.getAll();
    }

    @GetMapping(value = "/getLogsByLogsId/{logsId}")
    public LogsDto getEmployeesByEmployeeId(@PathVariable(value = "logsId") Long logsId) {
        return logsService.getLogsByLogsId(logsId);
    }

    @PostMapping(value = "/saveLogs")
    public void saveEmployees(@RequestBody LogsRequest logsRequest) {
        logsService.saveLogs(logsRequest);
    }

    @PostMapping(value = "/updateLogs")
    public void updateLogs(@RequestBody LogsRequest logsRequest) {
        logsService.updateLogs(logsRequest);
    }

    @DeleteMapping(value = "/deleteLogs/{logsId}")
    public void deleteById(@PathVariable(value = "logsId") Long logsId) {
        logsService.deleteById(logsId);
    }
}
