package com.example.bank_app.service.impl;

import com.example.bank_app.dto.TransactionsDto;
import com.example.bank_app.dto.request.TransactionsRequest;
import com.example.bank_app.model.Transactions;
import com.example.bank_app.repository.TransactionsRepository;
import com.example.bank_app.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionsServiceImpl implements TransactionsService {

    private final TransactionsRepository transactionsRepository;

    @Override
    public TransactionsDto getTransactionsByTransId(Long transId) {
        Transactions transactions = transactionsRepository.getTransactionsByTransId(transId);
        return TransactionsDto.builder()
                .name(transactions.getName())
                .build();
    }

    @Override
    public void saveTransactions(TransactionsRequest transactionsRequest) {
        Transactions transactions = Transactions.builder()
                .name(transactionsRequest.getName())
                .transId(transactionsRequest.getTransId())
                .employeeId(transactionsRequest.getEmployeeId())
                .customerId(transactionsRequest.getCustomerId())
                .build();

        transactionsRepository.save(transactions);
    }

    @Override
    public void updateTransactions(TransactionsRequest transactionRequest) {
        Transactions transaction = Transactions.builder()
                .transId(transactionRequest.getTransId())
                .name(transactionRequest.getName())
                .transId(transactionRequest.getTransId())
                .employeeId(transactionRequest.getEmployeeId())
                .customerId(transactionRequest.getCustomerId())
                .build();

        transactionsRepository.save(transaction);
    }

    @Override
    public List<TransactionsDto> getAll() {
        List<Transactions> transactions = transactionsRepository.findAll();
        List<TransactionsDto> transactionDtos = new ArrayList<>();

        for (Transactions transaction : transactions) {
            TransactionsDto transactionsDto = TransactionsDto.builder()
                    .name(transaction.getName())
                    .build();

            transactionDtos.add(transactionsDto);
        }

        return transactionDtos;
    }

    @Override
    public void deleteById(Long transId) {
        Transactions transaction = transactionsRepository.getTransactionsByTransId(transId);
        if (transaction.getName() == null) {
            throw new RuntimeException("bele id yoxdur");
        } else {
            transactionsRepository.deleteById(transId);

        }
    }
}