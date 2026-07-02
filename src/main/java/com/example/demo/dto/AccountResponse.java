package com.example.demo.dto;

import lombok.Data;

@Data
public class AccountResponse {
    private long accountId;
    private String accountIban;
    private String accountOwnerName;
    private double accountBalance;
}
