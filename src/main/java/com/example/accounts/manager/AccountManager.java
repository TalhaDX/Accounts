package com.example.accounts.manager;

import com.example.accounts.domain.Account;
import com.example.accounts.model.AccountModel;
import com.example.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AccountManager {

    private final AccountService accountService;


    public AccountModel register(AccountModel accountModel){

        Account account = new Account();
        account.setName(accountModel.getName());
        account.setEmail(accountModel.getEmail());
        account.setPassword(accountModel.getPassword());

        account = accountService.register(account);

        accountModel.setId(account.getId());

        return accountModel;

    }

    public AccountModel getAccount(UUID id) {
        Account account = accountService.find(id);

        AccountModel model = new AccountModel();
        model.setId(account.getId());
        model.setName(account.getName());
        model.setEmail(account.getEmail());

        return model;
    }

    public AccountModel update(UUID id, AccountModel model) {
        Account account = accountService.find(id);

        account.setName(model.getName());
        account.setEmail(model.getEmail());

        accountService.update(id, account);

        model.setId(account.getId());

        return model;
    }
}
