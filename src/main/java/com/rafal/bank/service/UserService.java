package com.rafal.bank.service;

import com.rafal.bank.model.User;

import java.util.Optional;

public interface UserService {
    User getUserByUsername(String username);
}
