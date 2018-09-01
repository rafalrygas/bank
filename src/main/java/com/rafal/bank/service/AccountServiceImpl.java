package com.rafal.bank.service;

import com.rafal.bank.model.Account;
import com.rafal.bank.model.User;
import com.rafal.bank.repository.AccountRepository;
import com.rafal.bank.security.AccountPermissionEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreFilter;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountPermissionEvaluator accountPermissionEvaluator;

    @Override
    @PostAuthorize("hasRole('ROLE_ADMIN') or @accountPermissionEvaluator.ownsAccount(returnObject)")
    public Account getAccountById(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public Set<User> getOwnersOfAccount(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).getUsers();
    }
}
