package com.rafal.bank.service;

import com.rafal.bank.model.User;
import com.rafal.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
