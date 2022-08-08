package com.example.accounts.service;

import com.example.accounts.domain.Account;
import com.example.accounts.exception.DuplicateException;
import com.example.accounts.exception.NotFoundException;
import com.example.accounts.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository repository;

    @Override
    public Account register(Account newAccount) throws DuplicateException {
        if(repository.findByEmail(newAccount.getEmail()) != null) throw new DuplicateException();

        return repository.save(newAccount);
    }

    @Override
    public Account update(UUID id, Account newAccount) throws NotFoundException {
        if(find(id) == null) throw new NotFoundException();

        return repository.save(newAccount);
    }

    @Override
    public Account find(UUID id){
        return repository.findById(id).get();
    }

    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }
}
