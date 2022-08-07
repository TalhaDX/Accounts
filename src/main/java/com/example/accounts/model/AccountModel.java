package com.example.accounts.model;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountModel {

    private UUID id;
    private String name;
    private String email;
    private String password;
}
