package com.example.bank_app.service;

import com.example.bank_app.dto.EmployeesDto;
import com.example.bank_app.dto.LogsDto;
import com.example.bank_app.dto.request.LogsRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface LogsService {

    LogsDto getLogsByLogsId (Long logsId);

    void saveLogs (LogsRequest logsRequest);
    void updateLogs (LogsRequest logsRequest);

    List<LogsDto> getAll();
    void deleteById(Long logsId);
}
