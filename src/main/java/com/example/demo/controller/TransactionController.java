package com.example.demo.controller;

import com.example.demo.dto.TransactionRequest;
import com.example.demo.model.Account;
import com.example.demo.model.Transaction;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    private final TransactionService transactionService;
    private final AccountService accountService;

    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public Transaction transfer(@Valid @RequestBody TransactionRequest request) {
        Account sender = accountService.getAccountById(request.getFromAccountId());
        Account receiver = accountService.getAccountById(request.getToAccountId());
        sender.setAccountBalance(sender.getAccountBalance() - request.getAmount());
        receiver.setAccountBalance(receiver.getAccountBalance() + request.getAmount());
        return transactionService.createTransaction(request);
    }

}
