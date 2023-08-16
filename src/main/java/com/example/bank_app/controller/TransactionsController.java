package com.example.bank_app.controller;

import com.example.bank_app.dto.TransactionsDto;
import com.example.bank_app.dto.request.TransactionsRequest;
import com.example.bank_app.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/transactions")
public class TransactionsController {

    private final TransactionsService transactionsService;

    @GetMapping(value = "/transactionsList")
    public List<TransactionsDto> getReportsInfo() {
        return transactionsService.getAll();
    }

    @GetMapping(value = "/gettransactionsBytransactionsId/{transactionsId}")
    public TransactionsDto gettransactionsBytransactionsId(@PathVariable(value = "transactionsId") Long transactionsId) {
        return transactionsService.getTransactionsByTransId(transactionsId);
    }

    @PostMapping(value = "/saveTransactions")
    public void saveTransactions(@RequestBody TransactionsRequest transactionsRequest) {
        transactionsService.saveTransactions(transactionsRequest);
    }

    @PostMapping(value = "/updateTransactions")
    public void updateTransactions(@RequestBody TransactionsRequest transactionsRequest) {
        transactionsService.updateTransactions(transactionsRequest);
    }

    @DeleteMapping(value = "/deleteReports/{transactionsId}")
    public void deleteById(@PathVariable(value = "transactionsId") Long transactionsId) {
        transactionsService.deleteById(transactionsId);
    }
}

