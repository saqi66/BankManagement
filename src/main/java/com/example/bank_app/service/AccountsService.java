package com.example.bank_app.service;
import com.example.bank_app.dto.AccountsDto;
import com.example.bank_app.dto.request.AccountsRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountsService {

    AccountsDto getAccountsByAccId(Long accId);


    void saveAccounts(AccountsRequest accountsRequest);

    void updateAccounts(AccountsRequest accountsRequest);

    List<AccountsDto> getAll();
    void deleteById(Long accId);
}
