package com.example.accounts.validation;

import com.example.accounts.type.account.AccountType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class AccountTypeValidator implements ConstraintValidator<ValidateAccountType, String> {


    @Override
    public boolean isValid(String accountType, ConstraintValidatorContext constraintValidatorContext) {
        return Arrays.stream(AccountType.values()).anyMatch(a -> a.toString().equals(accountType));
    }
}