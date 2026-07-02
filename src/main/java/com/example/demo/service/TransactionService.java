package com.example.demo.service;

import com.example.demo.dto.TransactionResponse;
import com.example.demo.dto.TransferRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TransactionService {

    private final List<TransactionResponse> transactions = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public TransactionResponse createTransfer(TransferRequest request) {
        TransactionResponse tx = new TransactionResponse();
        tx.setTransactionId(nextId.getAndIncrement());
        tx.setTransactionAccount(String.valueOf(request.getFromAccountId()));
        tx.setTransactionType("TRANSFER");
        tx.setTransactionAmount(request.getAmount());
        tx.setTransactionCreatedAt(LocalDateTime.now());
        tx.setTransactionNote(request.getNote());

        transactions.add(tx);  // ← SAVE IT
        return tx;
    }

    public List<TransactionResponse> getByAccountId(long accountId) {
        String accountIdStr = String.valueOf(accountId);
        return transactions.stream()
                .filter(t -> t.getTransactionAccount().equals(accountIdStr))
                .toList();
    }
}