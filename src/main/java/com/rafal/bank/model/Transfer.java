package com.rafal.bank.model;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "transfers")
public class Transfer {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name="transferID")
    private Integer id;

    @Column(name = "amount", nullable = false, columnDefinition = "Decimal(10,2)")
    private BigDecimal amount;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "addressRecipient", nullable = false)
    private String addressRecipient;

    @Column(name = "dateOfSent", nullable = false)
    private String dateOfSent;

    @Column(name = "dateOfReceipt")
    private String dateOfReceipt;

    @ManyToOne
    @JoinColumn(name = "accountNumberSender", nullable = false)
    private Account accountSender;

    @ManyToOne
    @JoinColumn(name = "accountNumberRecipient", nullable = false)
    private Account accountRecipient;

    @Column(name = "nameOfSender", nullable = false)
    private String nameOfSender;

    @Column(name = "nameOfRecipient")
    private String nameOfRecipient;

    @Column(name = "statusOfTransfer", nullable = false)
    private String statusOfTransfer;

    public Transfer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDateOfSent() {
        return dateOfSent;
    }

    public void setDateOfSent(String dateOfSent) {
        this.dateOfSent = dateOfSent;
    }

    public String getDateOfReceipt() {
        return dateOfReceipt;
    }

    public void setDateOfReceipt(String dateOfReceipt) {
        this.dateOfReceipt = dateOfReceipt;
    }

    public Account getAccountSender() {
        return accountSender;
    }

    public void setAccountSender(Account accountSender) {
        this.accountSender = accountSender;
    }

    public Account getAccountRecipient() {
        return accountRecipient;
    }

    public void setAccountRecipient(Account accountRecipient) {
        this.accountRecipient = accountRecipient;
    }

    public String getNameOfSender() {
        return nameOfSender;
    }

    public void setNameOfSender(String nameOfSender) {
        this.nameOfSender = nameOfSender;
    }

    public String getNameOfRecipient() {
        return nameOfRecipient;
    }

    public void setNameOfRecipient(String nameOfRecipient) {
        this.nameOfRecipient = nameOfRecipient;
    }

    public String getStatusOfTransfer() {
        return statusOfTransfer;
    }

    public void setStatusOfTransfer(String statusOfTransfer) {
        this.statusOfTransfer = statusOfTransfer;
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "id=" + id +
                ", amount=" + amount +
                ", title='" + title + '\'' +
                ", addressRecipient='" + addressRecipient + '\'' +
                ", dateOfSent='" + dateOfSent + '\'' +
                ", dateOfReceipt='" + dateOfReceipt + '\'' +
                ", nameOfSender='" + nameOfSender + '\'' +
                ", nameOfRecipient='" + nameOfRecipient + '\'' +
                ", statusOfTransfer='" + statusOfTransfer + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transfer transfer = (Transfer) o;
        return Objects.equals(id, transfer.id) &&
                Objects.equals(title, transfer.title) &&
                Objects.equals(addressRecipient, transfer.addressRecipient) &&
                Objects.equals(dateOfSent, transfer.dateOfSent) &&
                Objects.equals(dateOfReceipt, transfer.dateOfReceipt) &&
                Objects.equals(nameOfSender, transfer.nameOfSender) &&
                Objects.equals(nameOfRecipient, transfer.nameOfRecipient) &&
                Objects.equals(statusOfTransfer, transfer.statusOfTransfer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, title, addressRecipient, dateOfSent, dateOfReceipt, nameOfSender, nameOfRecipient, statusOfTransfer);
    }
}
