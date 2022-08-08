package com.example.accounts.mapper;

import com.example.accounts.domain.Account;
import com.example.accounts.model.AccountModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class AccountMapperTest {

    private AccountMapper mapper;

    @BeforeEach
    public void init(){
        mapper = new AccountMapperImpl();
    }


    @Test
    void whenModelNullReturnNull() {
        AccountModel model = null;
        Account account = mapper.toNewEntity(model);
        Assertions.assertNull(account);
    }

    @Test
    void whenModelOkayReturnAccount() {
        AccountModel model = new AccountModel(UUID.randomUUID(), "M. Talha", "talha@gmail.com", "123456");

        Account account = mapper.toNewEntity(model);
        Assertions.assertNotNull(account);
        Assertions.assertEquals("M. Talha", account.getName());
        Assertions.assertEquals("talha@gmail.com", account.getEmail());
        Assertions.assertEquals("123456", account.getPassword());
    }

    @Test
    void whenAccountOkayReturnModel() {
        Account account = new Account(UUID.randomUUID(), "M. Talha", "talha@gmail.com", "123456");

        AccountModel model = mapper.toModel(account);
        Assertions.assertNotNull(account);
        Assertions.assertEquals("M. Talha", model.getName());
        Assertions.assertEquals("talha@gmail.com", model.getEmail());
        Assertions.assertEquals("123456", model.getPassword());
    }

    //TODO: More tests can be written here on Manager level implementation using Mockito as well

}
