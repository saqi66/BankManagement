package com.example.bank_app.repository;

import com.example.bank_app.model.Accounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {

    Accounts getAccountsByAccId(Long accId);

}
