package com.example.demo.dto;

import lombok.Data;

@Data
public class TransactionRequest {
    private long fromAccountId;
    private long toAccountId;
    private double amount;
    private String note;
}
