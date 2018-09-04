package com.rafal.bank.service;

import com.rafal.bank.forms.MoneyTransferForm;
import com.rafal.bank.model.Transfer;

public interface TransferService {

    Integer startTransfer(MoneyTransferForm moneyTransferForm);
    boolean checkTransfer(Integer transferId, Integer checkCode);
    void finishTransfer(Transfer transfer);
    Transfer getTransferById(Integer id);
}
