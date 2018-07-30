package com.rafal.bank.service;

import com.rafal.bank.model.User;
import com.rafal.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userRepository.findAllEmployees();
    }
}
