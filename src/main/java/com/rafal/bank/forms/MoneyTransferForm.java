package com.rafal.bank.forms;

import com.rafal.bank.model.Account;

import javax.persistence.*;

import java.math.BigDecimal;

import static javax.persistence.GenerationType.IDENTITY;

public class MoneyTransferForm {

    private BigDecimal amount;

    private String title;

    private String addressRecipient;

    private String accountSender;

    private String accountRecipient;

    private String nameOfRecipient;

    public MoneyTransferForm() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddressRecipient() {
        return addressRecipient;
    }

    public void setAddressRecipient(String addressRecipient) {
        this.addressRecipient = addressRecipient;
    }

    public String getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(String accountSender) {
        this.accountSender = accountSender;
    }

    public String getAccountRecipient() {
        return accountRecipient;
    }

    public void setAccountRecipient(String accountRecipient) {
        this.accountRecipient = accountRecipient;
    }

    public String getNameOfRecipient() {
        return nameOfRecipient;
    }

    public void setNameOfRecipient(String nameOfRecipient) {
        this.nameOfRecipient = nameOfRecipient;
    }
}
