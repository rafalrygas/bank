package com.rafal.bank.repository;

import com.rafal.bank.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Account findByAccountNumber(String accountNumber) {
        List<Account> accounts = sessionFactory.getCurrentSession()
                .createQuery("from Account where accountNumber=?")
                .setParameter(0, accountNumber)
                .list();

        if (accounts.size() > 0) {
            return accounts.get(0);
        } else {
            return null;
        }
    }
}
