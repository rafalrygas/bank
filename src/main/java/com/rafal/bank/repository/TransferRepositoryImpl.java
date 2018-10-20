package com.rafal.bank.repository;

import com.rafal.bank.model.Account;
import com.rafal.bank.model.Transfer;
import com.rafal.bank.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public class TransferRepositoryImpl implements TransferRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Transfer findById(Integer id) {
        List<Transfer> transfers = sessionFactory.getCurrentSession()
                .createQuery("from Transfer where id=?")
                .setParameter(0, id)
                .list();

        if (transfers.size() > 0) {
            return transfers.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Transfer> findAll() {
        String sql = "FROM Transfer";
        List<Transfer> result = sessionFactory.getCurrentSession().createQuery(sql).list();
        return result;
    }

    @Override
    public Integer save(Transfer transfer) {
        return (Integer) sessionFactory.getCurrentSession().save(transfer);
    }

    @Override
    public void update(Transfer transfer) {
        sessionFactory.getCurrentSession().merge(transfer);
    }

    @Override
    public void delete(Integer id) {
        List<Transfer> transfers = sessionFactory.getCurrentSession()
                .createQuery("from Transfer where id=?")
                .setParameter(0, id)
                .list();
        System.out.println(transfers.get(0).getId());
        sessionFactory.getCurrentSession().delete(transfers.get(0));
    }

    @Override
    public List<Transfer> getTransfersByAccountNumber(Account accountNumber) {
        List<Transfer> transfers = sessionFactory.getCurrentSession()
                .createQuery("from Transfer where accountSender=? or accountRecipient=?")
                .setParameter(0, accountNumber).setParameter(1,accountNumber)
                .list();
        return transfers;
    }
}
