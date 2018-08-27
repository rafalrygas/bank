package com.rafal.bank.repository;

import com.rafal.bank.model.User;
import com.rafal.bank.model.UserRole;
import com.rafal.bank.service.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User findByUsername(String username) {

        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User where username=?")
                .setParameter(0, username)
                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

    @Override
    public List<User> findAll() {

        String sql = "FROM User";
        List<User> result = sessionFactory.getCurrentSession().createQuery(sql).list();
        return result;

    }

    @Override
    public void save(User user) {
        System.out.print("saving");
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void update(User user) {
        System.out.print("updating");
        sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void delete(String username) {
        List<User> users = sessionFactory.getCurrentSession()
                .createQuery("from User where username=?")
                .setParameter(0, username)
                .list();
        System.out.println(users.get(0).getUsername());
        sessionFactory.getCurrentSession().delete(users.get(0));
    }

}
