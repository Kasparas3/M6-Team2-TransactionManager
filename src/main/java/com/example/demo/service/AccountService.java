package com.example.demo.service;

import com.example.demo.dto.CreateAccountRequest;
import com.example.demo.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AccountService {
    private final List<Account> accounts = new ArrayList<>();

    private final AtomicLong nextId = new AtomicLong(1);
    private final Random random = new Random();

    public Account createAccount(CreateAccountRequest request) {
        Account newAccount = buildAccount(request);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account getAccountById(long id) {
        return accounts.stream().filter(a -> a.getAccountId() == id).findFirst().orElse(null);
    }

    private Account buildAccount(CreateAccountRequest request) {
        Account account = new Account();
        account.setAccountId(nextId.getAndIncrement());
        account.setAccountOwnerName(request.getAccountOwnerName());
        account.setAccountIban(generateIban());
        account.setAccountBalance(request.getBalance());
        return account;
    }


    private String generateIban() {
        StringBuilder numberSequence = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            numberSequence.append(String.valueOf(random.nextInt(10)));
        }

        return "LT" + numberSequence.toString();
    }
}
