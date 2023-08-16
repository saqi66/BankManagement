package com.example.bank_app.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CurrentTimestamp;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "logs_id")
    private Long logsId;
    @Column(name = "trans_id")
    private Long transId;
    @CurrentTimestamp
    @Column(name = "login_date")
    private Date loginDate;
    @Column(name = "login_time")
    private String loginTime;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "transactions_trans_id")
    private Transactions transactions;

    @OneToMany(mappedBy = "logs", orphanRemoval = true)
    private List<Reports> reportses = new ArrayList<>();


}
