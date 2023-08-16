package com.example.bank_app.service.impl;

import com.example.bank_app.dto.AccountsDto;
import com.example.bank_app.dto.request.AccountsRequest;
import com.example.bank_app.model.Accounts;
import com.example.bank_app.repository.AccountsRepository;
import com.example.bank_app.service.AccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountsServiceImpl implements AccountsService {

    private final AccountsRepository accountsRepository;

    @Override
    public AccountsDto getAccountsByAccId(Long accId) {
        Accounts accounts = accountsRepository.getAccountsByAccId(accId);
        return AccountsDto.builder()
                .name(accounts.getName())
                .build();
    }

    @Override
    public void saveAccounts(AccountsRequest accountsRequest) {
        Accounts accounts = Accounts.builder()
                .name(accountsRequest.getName())
                .customerId(accountsRequest.getCustomerId())
                .build();

        accountsRepository.save(accounts);
    }

    @Override
    public void updateAccounts(AccountsRequest accountsRequest) {
        Accounts accounts = Accounts.builder()
                .accId(accountsRequest.getAccId())
                .customerId(accountsRequest.getCustomerId())
                .name(accountsRequest.getName())
                .build();

        accountsRepository.save(accounts);
    }

    @Override
    public List<AccountsDto> getAll() {
        List<Accounts> accounts = accountsRepository.findAll();
        List<AccountsDto> accountsDtos = new ArrayList<>();

        for (Accounts account : accounts) {
            AccountsDto accountsDto = AccountsDto.builder()
                    .name(account.getName())
                    .build();

            accountsDtos.add(accountsDto);
        }

        return accountsDtos;
    }

    @Override
    public void deleteById(Long accId) {
        Accounts accounts = accountsRepository.getAccountsByAccId(accId);
        if (accounts.getName() == (null)) {
            throw new RuntimeException("bele id yoxdur");

        } else {
            accountsRepository.deleteById(accId);
        }
    }
}
