package com.example.demo.controller;

import com.example.demo.dto.TransactionRequest;
import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping("/transfer")
    public Transaction transfer(@RequestBody TransactionRequest request) {
        return transactionService.createTransaction(request);
    }
}
