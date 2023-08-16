package com.example.bank_app.repository;

import com.example.bank_app.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionsRepository extends JpaRepository<Transactions, Long> {

    Transactions getTransactionsByTransId(Long transId);


}
