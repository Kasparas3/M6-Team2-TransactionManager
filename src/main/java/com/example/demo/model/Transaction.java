package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    private Long transactionId;
    private Long transactionAccountId;
    private String transactionType;
    private double transactionAmount;
    private LocalDateTime transactionCreatedAt;
    private String transactionNote;

}
