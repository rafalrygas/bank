package com.rafal.bank.service;

import com.rafal.bank.forms.MoneyTransferForm;
import com.rafal.bank.model.Account;
import com.rafal.bank.model.Transfer;
import com.rafal.bank.model.User;
import com.rafal.bank.repository.AccountRepository;
import com.rafal.bank.repository.TransferRepository;
import com.rafal.bank.repository.UserRepository;
import com.rafal.bank.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class TransferServiceImpl implements TransferService {

    @Autowired
    TransferRepository transferRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityCodeService securityCodeService;

    @Transactional
    public Transfer getTransferById(Integer id) {
       return transferRepository.findById(id);
    }

    @Override
    public List<Transfer> getTransfersByAccountNumber(Account account) {
        return transferRepository.getTransfersByAccountNumber(account);
    }

    @Transactional
    public Integer startTransfer(MoneyTransferForm moneyTransferForm) {
        Transfer transfer = createTransfer(moneyTransferForm);
        transferRepository.save(transfer);
        securityCodeService.saveSecurityCode(transfer.getId());
        securityCodeService.sendCode(transfer.getId());
        return transfer.getId();
    }

    public Transfer createTransfer(MoneyTransferForm moneyTransferForm) {
        Transfer transfer = new Transfer();
        transfer.setAccountRecipient(accountRepository.findByAccountNumber(moneyTransferForm.getAccountRecipient()));
        transfer.setAccountSender(accountRepository.findByAccountNumber(moneyTransferForm.getAccountSender()));
        transfer.setAddressRecipient(moneyTransferForm.getAddressRecipient());
        transfer.setAmount(moneyTransferForm.getAmount());
        transfer.setDateOfSent(LocalDateTime.now().toString());
        transfer.setTitle(moneyTransferForm.getTitle());
        transfer.setStatusOfTransfer("Started");
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        transfer.setNameOfSender(user.getName() + " " + user.getSurname());
        return transfer;
    }

    @Transactional
    public boolean checkTransfer(Integer transferId, String securityCode) {
        Transfer transfer = transferRepository.findById(transferId);
        if (securityCodeService.compareCodes(transferId, securityCode)) {
            transfer.setStatusOfTransfer("Confirmed");
            transferRepository.save(transfer);
            System.out.println("TRANSFER CONFIRMED");
            finishTransfer(transfer);
            return true;
        } else {
            transfer.setStatusOfTransfer("Rejected");
            System.out.println("TRANSFER REJECTED");
            transferRepository.save(transfer);
            return false;
        }
    }

    public void finishTransfer(Transfer transfer) {
        Account accountSender = transfer.getAccountSender();
        accountSender.setState(accountSender.getState().subtract(transfer.getAmount()));
        Account accountRecipient = transfer.getAccountRecipient();
        accountRecipient.setState(accountRecipient.getState().add(transfer.getAmount()));
        transfer.setDateOfReceipt(LocalDateTime.now().toString());
        transfer.setStatusOfTransfer("Finished");
        transferRepository.save(transfer);
        System.out.println("FINISHED TRANSFER");
    }

}
