package com.example.accounts.service;

import com.example.accounts.domain.Account;
import com.example.accounts.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public Account register(Account newAccount) {
        return repository.save(newAccount);
    }

    @Override
    public Account update(UUID id, Account newAccount) {
        Account account = repository.findById(id).get();

        account.setName(newAccount.getName());
        account.setEmail(newAccount.getEmail());

        return repository.save(account);
    }
}
