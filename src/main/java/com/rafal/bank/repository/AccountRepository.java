package com.rafal.bank.repository;

import com.rafal.bank.model.Account;

import java.util.List;

public interface AccountRepository {

    Account findByAccountNumber(String accountNumber);

    List<Account> findAll();

    void save(Account account);

    void update(Account account);

    void delete(String accountNumber);
}
