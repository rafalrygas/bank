package com.rafal.bank.repository;

import com.rafal.bank.model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAllEmployees();
}