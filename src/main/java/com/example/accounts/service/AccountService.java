package com.example.accounts.service;

import com.example.accounts.domain.Account;

import java.util.UUID;

public interface AccountService {

    Account register(Account newAccount);

    Account update(UUID id, Account newAccount);
}
