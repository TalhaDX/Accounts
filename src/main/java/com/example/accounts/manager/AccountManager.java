package com.example.accounts.manager;

import com.example.accounts.domain.Account;
import com.example.accounts.mapper.AccountMapper;
import com.example.accounts.model.AccountModel;
import com.example.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountManager {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountMapper accountMapper;

    public AccountModel register(AccountModel accountModel){

        Account account = accountMapper.toNewEntity(accountModel);
        account = accountService.register(account);

        return accountMapper.toModel(account);

    }

    public AccountModel getAccount(UUID id) {
        Account account = accountService.find(id);
        return accountMapper.toModel(account);
    }

    public AccountModel update(UUID id, AccountModel model) {
        Account account = accountMapper.toEntity(model);
        account.setId(id);
        accountService.update(id, account);

        return accountMapper.toModel(account);
    }
}
