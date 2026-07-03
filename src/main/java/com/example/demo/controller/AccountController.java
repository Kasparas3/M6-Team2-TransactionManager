package com.example.demo.controller;

import com.example.demo.dto.AccountResponse;
import com.example.demo.dto.CreateAccountRequest;
import com.example.demo.dto.TransactionResponse;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
public class AccountController {

    private final TransactionService transactionService;

    public AccountController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/account")
    public AccountResponse createAccount(@Valid @RequestBody CreateAccountRequest request) {
        AccountResponse response = new AccountResponse();
        response.setAccountId(1);
        response.setAccountIban("PT50001234567890123456789");
        response.setAccountOwnerName(request.getAccountOwnerName());
        response.setAccountBalance(0.0);
        return response;
    }

    @GetMapping("/account/{id}")
    public AccountResponse getAccount(@PathVariable long id) {
        AccountResponse response = new AccountResponse();
        response.setAccountId(id);
        response.setAccountIban("PT50001234567890123456789");
        response.setAccountOwnerName("Alice");
        response.setAccountBalance(100.0);
        return response;
    }

    @GetMapping("/account/{id}/transactions")
    public List<TransactionResponse> getTransactions(@PathVariable long id) {
        return transactionService.getByAccountId(id);  // reads from same list
    }
}
