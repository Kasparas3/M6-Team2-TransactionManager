package com.example.demo.service;

import com.example.demo.dto.TransactionRequest;
import com.example.demo.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public Transaction createTransaction(TransactionRequest request) {
        Transaction newTransaction = buildTransaction(request);
        transactions.add(newTransaction);
        return newTransaction;
    }

    public List<Transaction> getByAccountId(long accountId) {
        return transactions.stream()
                .filter(t -> t.getTransactionAccountId() == accountId)
                .toList();
    }

    private Transaction buildTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setTransactionId(nextId.getAndIncrement());
        transaction.setTransactionAccountId(request.getFromAccountId());
        transaction.setTransactionType("TRANSFER");
        transaction.setTransactionAmount(request.getAmount());
        transaction.setTransactionCreatedAt(LocalDateTime.now());
        transaction.setTransactionNote(request.getNote());
        return transaction;
    }
}
