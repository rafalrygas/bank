package com.rafal.bank.service;

import com.rafal.bank.model.User;
import com.rafal.bank.model.UserRole;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {
    User getUserByUsername(String username);
    List<User> findAll();
    void saveOrUpdate(User user);
    void delete(String username);
    public Set<UserRole> getUserRoles(String username);
}
