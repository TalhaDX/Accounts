package com.example.accounts.manager;

import com.example.accounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountManager {

    private final AccountService accountService;

}
