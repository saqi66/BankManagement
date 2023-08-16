package com.example.bank_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Date;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reports {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id")
    private Long reportId;
    @Column(name = "acc_id")
    private Long accId;
    @Column(name = "logs_id")
    private Long logsId;
    @Column(name = "trans_id")
    private Long transId;
    @Column(name = "report_name")
    private String reportName;
    @CurrentTimestamp
    @Column(name = "report_date")
    private Date reportDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transactions_trans_id")
    private Transactions transactions;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logs_logs_id")
    private Logs logs;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accounts_acc_id")
    private Accounts accounts;

}
