package com.example.demo.dto;

import lombok.Data;

@Data
public class TransactionRequest {
    private Long fromAccountId;
    private Long toAccountId;
    private double amount;
    private String note;
}
