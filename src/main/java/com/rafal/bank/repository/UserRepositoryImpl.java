package com.rafal.bank.repository;

import com.rafal.bank.model.User;
import com.rafal.bank.service.UserService;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    SessionFactory sessionFactory;

    public List<User> findAllEmployees() {
        List<User> result = (List<User>) sessionFactory.getCurrentSession().createQuery("from User").list();
        return result;
    }
}
