package com.rafal.bank.security;

import com.rafal.bank.model.Account;
import com.rafal.bank.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

@Component
public class AccountPermissionEvaluator {
    public boolean ownsAccount(Account account) {
        for (User user: account.getUsers()) {
            if (user.getUsername().equals(SecurityContextHolder.getContext().getAuthentication().getName()))
                return true;
        }
        return false;
    }


}

