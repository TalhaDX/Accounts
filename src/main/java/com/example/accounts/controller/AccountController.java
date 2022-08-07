package com.example.accounts.controller;


import com.example.accounts.manager.AccountManager;
import com.example.accounts.model.AccountModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountManager manager;

    @PostMapping
    public AccountModel register(@RequestBody AccountModel model){
        return manager.register(model);
    }

    @GetMapping("/{id}")
    public AccountModel getAccount(@PathVariable UUID id){
        return manager.getAccount(id);
    }

    @PutMapping("/{id}")
    public AccountModel updateAccount(@PathVariable UUID id, @RequestBody AccountModel model){
        return manager.update(id, model);
    }

    @GetMapping("/all")
    public List<AccountModel> getAll(){
        return manager.getAllAccounts();
    }
}
