package com.example.demo.controller;

import com.example.demo.dto.CreateAccountRequest;
import com.example.demo.model.Account;
import com.example.demo.model.Transaction;
import com.example.demo.service.AccountService;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {


    private final AccountService accountService;
    private final TransactionService transactionService;

    public AccountController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @PostMapping("/account")
    public Account createAccount(@Valid @RequestBody CreateAccountRequest request) {
        return accountService.createAccount(request);
    }

    @GetMapping("/account/{id}")
    public Account getAccount(@PathVariable long id) {
        return accountService.getAccountById(id);
    }

    @GetMapping("/account/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable long id) {
        return transactionService.getByAccountId(id);
    }

}
