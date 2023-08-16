package com.example.bank_app.service.impl;

import com.example.bank_app.dto.LogsDto;
import com.example.bank_app.dto.request.LogsRequest;
import com.example.bank_app.model.Logs;
import com.example.bank_app.repository.LogsRepository;
import com.example.bank_app.service.LogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LogsServiceImpl implements LogsService {

    private final LogsRepository logsRepository;


    @Override
    public LogsDto getLogsByLogsId(Long logsId) {
        Logs logs = logsRepository.getLogsByLogsId(logsId);
        return LogsDto.builder()
                .loginDate(logs.getLoginDate())
                .loginTime(logs.getLoginTime())
                .build();
    }

    @Override
    public void saveLogs(LogsRequest logsRequest) {
        Logs logs = Logs.builder()
                .loginTime(logsRequest.getLoginTime())
                .loginDate(logsRequest.getLoginDate())
                .transId(logsRequest.getTransId())
                .build();


        logsRepository.save(logs);
    }

    @Override
    public void updateLogs(LogsRequest logsRequest) {
        Logs logs = Logs.builder()
                .logsId(logsRequest.getLogsId())
                .loginTime(logsRequest.getLoginTime())
                .loginDate(logsRequest.getLoginDate())
                .transId(logsRequest.getTransId())
                .build();

        logsRepository.save(logs);
    }

    @Override
    public List<LogsDto> getAll() {
        List<Logs> logs = logsRepository.findAll();
        List<LogsDto> logsDtos = new ArrayList<>();

        for (Logs logs1 : logs) {
            LogsDto logsDto = LogsDto.builder()
                    .loginDate(logs1.getLoginDate())
                    .loginTime(logs1.getLoginTime())
                    .build();

            logsDtos.add(logsDto);
        }

        return logsDtos;
    }

    @Override
    public void deleteById(Long logsId) {
        Logs logs = logsRepository.getLogsByLogsId(logsId);
        if (logs.getLogsId() == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            logsRepository.deleteById(logsId);
        }
    }
}