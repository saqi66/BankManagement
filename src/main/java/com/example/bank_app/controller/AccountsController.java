package com.example.bank_app.controller;

import com.example.bank_app.dto.AccountsDto;
import com.example.bank_app.dto.request.AccountsRequest;
import com.example.bank_app.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/accounts")
public class AccountsController {

    private final AccountsService accountsService;

    @GetMapping(value = "/accountList")
    public List<AccountsDto> getAccountInfo() {
        return accountsService.getAll();
    }

    @GetMapping(value = "/getAccountsByAccId/{accId}")
    public AccountsDto getAccountsByAccId(@PathVariable(value = "accId") Long accId) {
        return accountsService.getAccountsByAccId(accId);
    }

    @PostMapping(value = "/saveAccounts")
    public void saveAccounts(@RequestBody AccountsRequest accountsRequest) {
        accountsService.saveAccounts(accountsRequest);
    }

    @PostMapping(value = "/updateAccounts")
    public void updateAccounts(@RequestBody AccountsRequest accountsRequest) {
        accountsService.updateAccounts(accountsRequest);
    }

    @DeleteMapping(value = "/deleteAccounts/{accId}")
    public void deleteById(@PathVariable(value = "accId") Long accId) {
        accountsService.deleteById(accId);
    }
}
