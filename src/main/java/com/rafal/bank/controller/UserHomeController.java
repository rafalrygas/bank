package com.rafal.bank.controller;

import com.rafal.bank.model.Account;
import com.rafal.bank.model.User;
import com.rafal.bank.service.AccountService;
import com.rafal.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Set;

@Controller
@RequestMapping("/secure")
public class UserHomeController {

    @Autowired
    UserService userService;

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String userHomePage(Model model) {
        Set<Account> accounts = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getAccounts();
        model.addAttribute("accounts", accounts);
        return "menuUser";
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public String userInfoPage(Model model) {
        return "userInfo";
    }


    @RequestMapping(value = "/account/{accountId}", method = RequestMethod.GET)
    public String getAccountDetails(@PathVariable String accountId, Model model) {
        model.addAttribute("account", accountService.getAccountById(accountId));
        for (User user: accountService.getAccountById(accountId).getUsers()) {
            System.out.println(user.getName() + " " + user.getSurname());
        }
        return "accountDetails";
    }

}

