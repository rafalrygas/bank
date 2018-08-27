package com.rafal.bank.repository;

import com.rafal.bank.model.User;

import java.util.List;

public interface UserRepository {
    User findByUsername(String username);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void delete(String username);
}
