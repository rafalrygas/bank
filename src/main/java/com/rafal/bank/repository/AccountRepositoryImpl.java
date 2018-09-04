package com.rafal.bank.repository;

import com.rafal.bank.model.Account;
import com.rafal.bank.model.User;
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

    @Override
    public List<Account> findAll() {

        String sql = "FROM Account";
        List<Account> result = sessionFactory.getCurrentSession().createQuery(sql).list();
        return result;

    }

    @Override
    public void save(Account account) {
        sessionFactory.getCurrentSession().save(account);
    }

    @Override
    public void update(Account account) {
        sessionFactory.getCurrentSession().merge(account);
    }

    @Override
    public void delete(String accountNumber) {
        List<Account> accounts = sessionFactory.getCurrentSession()
                .createQuery("from Account where accountNumber=?")
                .setParameter(0, accountNumber)
                .list();
        System.out.println(accounts.get(0).getAccountNumber());
        sessionFactory.getCurrentSession().delete(accounts.get(0));
    }
}
