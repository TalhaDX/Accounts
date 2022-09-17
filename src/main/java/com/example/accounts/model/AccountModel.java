package com.example.accounts.model;

import com.example.accounts.validation.ValidateAccountType;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class AccountModel {

    private UUID id;
    @NotNull(message = "Name is required")
    private String name;
    @Email(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password can not be empty")
    private String password;
    @ValidateAccountType
    private String type;
}
