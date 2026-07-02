package com.example.demo.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TransactionResponse {
    private long transactionId;
    private String transactionAccount;
    private String transactionType;
    private double transactionAmount;
    private LocalDateTime transactionCreatedAt;
    private String transactionNote;
}