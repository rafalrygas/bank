package com.rafal.bank.service;

import com.rafal.bank.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    UserRoleRepository userRoleRepository;

    public void delete(int userRoleId) {
        userRoleRepository.delete(userRoleId);
    }
}
