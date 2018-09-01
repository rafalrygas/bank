package com.rafal.bank.service;

import com.rafal.bank.model.Account;
import com.rafal.bank.model.User;

import java.util.Set;

public interface AccountService {
    Account getAccountById(String accountNumber);
    Set<User> getOwnersOfAccount(String accountNumber);
}
