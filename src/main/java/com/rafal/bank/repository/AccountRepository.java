package com.rafal.bank.repository;

import com.rafal.bank.model.Account;

public interface AccountRepository {

    Account findByAccountNumber(String accountNumber);
}
