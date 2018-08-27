package com.rafal.bank.service;

import com.rafal.bank.model.User;
import com.rafal.bank.model.UserRole;
import com.rafal.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void saveOrUpdate(User user) {

        if (getUserByUsername(user.getUsername())==null) {
            userRepository.save(user);
        } else {
            userRepository.update(user);
        }

    }

    public void delete(String username) {
        userRepository.delete(username);
    }

    public Set<UserRole> getUserRoles(String username) {
        return userRepository.findByUsername(username).getUserRole();
    }
}
