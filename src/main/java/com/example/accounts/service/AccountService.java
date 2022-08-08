package com.example.accounts.service;

import com.example.accounts.domain.Account;
import com.example.accounts.exception.DuplicateException;
import com.example.accounts.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface AccountService {

    Account register(Account newAccount) throws DuplicateException;

    Account update(UUID id, Account newAccount) throws NotFoundException;

    Account find(UUID id) throws NotFoundException;

    List<Account> findAll();
}
