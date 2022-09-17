package com.example.accounts.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AccountTypeValidator.class)
public @interface ValidateAccountType {

    public String message() default "Invalid AccountType - Only USER, EMPLOYEE, ADMIN type supported";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
