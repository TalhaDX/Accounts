package com.example.accounts.service;

import com.example.accounts.domain.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account register(Account newAccount);

    Account update(UUID id, Account newAccount);

    Account find(UUID id);

    List<Account> findAll();
}
