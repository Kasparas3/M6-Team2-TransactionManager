package com.example.demo.controller;

import com.example.demo.dto.TransactionResponse;
import com.example.demo.dto.TransferRequest;
import com.example.demo.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
public class TransferController {

    private final TransactionService transactionService;
    public TransferController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @PostMapping("/transfer")
    public TransactionResponse transfer(@RequestBody TransferRequest request) {
        return transactionService.createTransfer(request);  // saves + returns
    }
}