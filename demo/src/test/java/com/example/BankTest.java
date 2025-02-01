// BankTest.java
package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        bank = new Bank();
    }

    @Test
    void testCreateAccount() {
        Account account = bank.createAccount("12345");
        assertNotNull(account);
        assertEquals("12345", account.getAccountNumber());
    }

    @Test
    void testCreateExistingAccount() {
        bank.createAccount("12345");
        assertThrows(IllegalArgumentException.class, () -> bank.createAccount("12345"));
    }


    @Test
    void testDeposit() {
        Account account = bank.createAccount("12345");
        account.deposit(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testDepositNegativeAmount() {
       Account account = bank.createAccount("12345");
       assertThrows(IllegalArgumentException.class, () -> account.deposit(-100));
    }


    @Test
    void testWithdraw() {
        Account account = bank.createAccount("12345");
        account.deposit(200);
        account.withdraw(100);
        assertEquals(100, account.getBalance());
    }

    @Test
    void testWithdrawInsufficientFunds() {
        Account account = bank.createAccount("12345");
        assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
    }

    @Test
    void testWithdrawNegativeAmount() {
        Account account = bank.createAccount("12345");
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-100));
    }
}