package com.rafal.bank.controller;

import com.rafal.bank.forms.MoneyTransferForm;
import com.rafal.bank.model.Account;
import com.rafal.bank.model.Transfer;
import com.rafal.bank.repository.TransferRepository;
import com.rafal.bank.service.AccountService;
import com.rafal.bank.service.TransferService;
import com.rafal.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/secure")
public class UserAccountController {

    @Autowired
    UserService userService;

    @Autowired
    TransferService transferService;

    // show update form
    @RequestMapping(value = "/maketransfer", method = RequestMethod.GET)
    public String showTransferForm(Model model) {

        MoneyTransferForm moneyTransferForm = new MoneyTransferForm();
        model.addAttribute("moneyTransferForm", moneyTransferForm);

        List<String> accountNumbers = new ArrayList<String>();
        for (Account account: userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getAccounts()) {
            accountNumbers.add(account.getAccountNumber());
        }
        model.addAttribute("accounts", accountNumbers);
        return "moneyTransferForm";

    }

    @RequestMapping(value = "/maketransfer", method = RequestMethod.POST)
    public String makeTransfer(@ModelAttribute("moneyTransferForm") @Validated MoneyTransferForm moneyTransferForm,
                               BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "moneyTransferForm";
        } else {

            System.out.println(transferService.startTransfer(moneyTransferForm));
            System.out.println(transferService.checkTransfer(2,2));
            Transfer transfer = transferService.getTransferById(4);
            System.out.println(transfer.getId());

            // POST/REDIRECT/GET
            return "redirect:/secure/home";

        }

    }



}
