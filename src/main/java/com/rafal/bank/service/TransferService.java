package com.rafal.bank.service;

import com.rafal.bank.forms.MoneyTransferForm;
import com.rafal.bank.model.Account;
import com.rafal.bank.model.Transfer;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface TransferService {

    Integer startTransfer(MoneyTransferForm moneyTransferForm);
    boolean checkTransfer(Integer transferId, String checkCode);
    void finishTransfer(Transfer transfer);
    Transfer getTransferById(Integer id);
    List<Transfer> getTransfersByAccountNumber(Account account);
}
