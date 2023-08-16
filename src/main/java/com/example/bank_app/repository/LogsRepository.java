package com.example.bank_app.repository;

import com.example.bank_app.model.Logs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Long> {

    Logs getLogsByLogsId(Long logsId);}
