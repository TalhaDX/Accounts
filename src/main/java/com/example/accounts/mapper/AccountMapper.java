package com.example.accounts.mapper;

import com.example.accounts.domain.Account;
import com.example.accounts.model.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UUIDMapper.class})
public interface AccountMapper {

    @Mapping(target = "id", ignore = true)
    Account toNewEntity(AccountModel model);
    Account toEntity(AccountModel model);

    AccountModel toModel(Account account);
}
