package com.rafal.bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/secure")
public class UserHomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String userHomePage(Model model) {
        return "menuUser";
    }

    @RequestMapping(value = "/userinfo", method = RequestMethod.GET)
    public String userInfoPage(Model model) {
        return "userInfo";
    }


}

