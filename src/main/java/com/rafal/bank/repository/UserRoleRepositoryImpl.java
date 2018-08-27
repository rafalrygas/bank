package com.rafal.bank.repository;

import com.rafal.bank.model.UserRole;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRoleRepositoryImpl implements  UserRoleRepository{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void delete(int userRoleId) {
        System.out.println(userRoleId);
        List<UserRole> userRole = sessionFactory.getCurrentSession()
                .createQuery("from UserRole where userRoleId=?")
                .setParameter(0, userRoleId)
                .list();
        System.out.println(userRole.get(0).getUserRoleId());
        sessionFactory.getCurrentSession().delete(userRole.get(0));
    }
}
