package com.example.accounts.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Document(collection = "account")
public class Account {

    @Id
    @Generated
    private UUID id;
    private String name;
    private String email;
    private String password;
}
