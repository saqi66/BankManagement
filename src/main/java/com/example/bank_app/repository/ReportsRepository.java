package com.example.bank_app.repository;

import com.example.bank_app.model.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<Reports, Long> {

    Reports getReportsByReportId(Long reportId);
}