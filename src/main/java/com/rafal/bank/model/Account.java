package com.rafal.bank.model;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @Column(name = "accountNumber", unique = true)
    @Length(min = 28, max = 28)
    private String accountNumber;
    @Column(name = "amount", nullable = false, columnDefinition = "Decimal(10,2)")
    private BigDecimal state;
    @ManyToMany
    @JoinTable(name = "Account_user", joinColumns = {
            @JoinColumn(name = "accountNumber", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "username",
                    nullable = false, updatable = false) })
    private Set<User> users = new HashSet<>();

    public Account() {
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", users=" + users +
                '}';
    }


    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(users, account.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, users);
    }
}
