package com.example.bank_app.service;

import com.example.bank_app.dto.TransactionsDto;
import com.example.bank_app.dto.request.TransactionsRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionsService {

    TransactionsDto getTransactionsByTransId(Long transId);

    void saveTransactions(TransactionsRequest transactionsRequest);

    void updateTransactions(TransactionsRequest transactionsRequest);

    List<TransactionsDto> getAll();

    void deleteById(Long transId);
}
