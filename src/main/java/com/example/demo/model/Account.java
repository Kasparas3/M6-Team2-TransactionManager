package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private long accountId;
    private String accountIban;
    private String accountOwnerName;
    private double accountBalance;

}
