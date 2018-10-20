package com.rafal.bank.controller;

import com.rafal.bank.forms.MoneyTransferForm;
import com.rafal.bank.model.Account;
import com.rafal.bank.model.Transfer;
import com.rafal.bank.repository.TransferRepository;
import com.rafal.bank.service.AccountService;
import com.rafal.bank.service.TransferService;
import com.rafal.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/secure")
public class UserAccountController {

    @Autowired
    UserService userService;

    @Autowired
    TransferService transferService;

    @Autowired
    AccountService accountService;

    @Autowired
    private MessageSource messageSource;

    @RequestMapping(value = "/maketransfer", method = RequestMethod.GET)
    public String showTransferForm(Model model) {

        MoneyTransferForm moneyTransferForm = new MoneyTransferForm();
        model.addAttribute("moneyTransferForm", moneyTransferForm);

        List<String> accountNumbers = new ArrayList<String>();
        for (Account account : userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getAccounts()) {
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
            Integer id = transferService.startTransfer(moneyTransferForm);

            // POST/REDIRECT/GET
            return "redirect:/secure/confirmtransfer/" + id;

        }

    }

    @RequestMapping(value = "/confirmtransfer/{id}", method = RequestMethod.GET)
    public String showTransferAcceptForm(@PathVariable Integer id, Model model) {

        model.addAttribute("transferId", id);
        return "moneyTransferAcceptForm";

    }

    @RequestMapping(value = "/confirmtransfer/{id}", method = RequestMethod.POST)
    public String confirmTransfer(@PathVariable Integer id, @ModelAttribute("checkCode") String checkCode, Model model, final RedirectAttributes redirectAttributes) {
        System.out.println("CHECKCODE IS: " + checkCode);
        if (transferService.checkTransfer(id, checkCode)) {
            redirectAttributes.addFlashAttribute("resources/css", "success");
            redirectAttributes.addFlashAttribute("msg",
                    messageSource.getMessage("userAccountController.TransferSuccessful", null, LocaleContextHolder.getLocale()));
            return "redirect:/secure/home";
        } else {
            redirectAttributes.addFlashAttribute("resources/css", "error");
            redirectAttributes.addFlashAttribute("msg",
                    messageSource.getMessage("userAccountController.SecurityCodeError", null, LocaleContextHolder.getLocale()));
            return "redirect:/secure/confirmtransfer/" + id;
        }
    }

    @RequestMapping(value = "/transferlist", method = RequestMethod.GET)
    public String confirmTransfer(Model model) {
        Set<Account> accounts = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName()).getAccounts();
        Set<Transfer> transfers = new HashSet<>();
        for (Account account: accounts) {
            transfers.addAll(transferService.getTransfersByAccountNumber(account));
        }
        model.addAttribute("transfers", transfers);
        return "transferList";
    }



}
