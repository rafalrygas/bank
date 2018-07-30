package com.rafal.bank.controller;

import com.rafal.bank.model.User;
import com.rafal.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model) {
        List<User> users = userService.getAllUsers();
        if (users.size() > 0)
            model.addAttribute("users", users.get(0));
        return "home";
    }
}
