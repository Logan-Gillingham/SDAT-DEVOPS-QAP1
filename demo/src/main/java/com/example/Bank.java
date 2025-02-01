package com.example;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public Account createAccount(String accountNumber) {
        if (accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account with this number already exists.");
        }
        Account newAccount = new Account(accountNumber);
        accounts.put(accountNumber, newAccount);
        return newAccount;
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}