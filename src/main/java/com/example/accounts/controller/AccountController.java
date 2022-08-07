package com.example.accounts.controller;


import com.example.accounts.manager.AccountManager;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountManager manager;

}
