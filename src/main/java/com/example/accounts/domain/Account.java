package com.example.accounts.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Document(collection = "account")
public class Account {

    @Id
    private UUID id;
    private String name;
    private String email;
    private String password;

    public Account(){
        this.id = UUID.randomUUID();
    }
}
