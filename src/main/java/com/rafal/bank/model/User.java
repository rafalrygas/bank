package com.rafal.bank.model;


import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "username", unique = true)
    @Length(min = 1, message = "{userFormValidator.username.empty}")
    private String username;
    @Length(min = 1, message = "{userFormValidator.password.minCharacters}")
    @Column(name = "password")
    private String password;
    @Column(name = "enabled")
    private boolean enabled;
    @Column(name = "name")
    @Length(min = 1, message = "{userFormValidator.name.empty}")
    private String name;
    @Column(name = "surname")
    @Length(min = 1, message = "{userFormValidator.surname.empty}")
    private String surname;
    @Column(name = "street")
    @Length(min = 1, message = "{userFormValidator.street.empty}")
    private String street;
    @Column(name = "city")
    @Length(min = 1, message = "{userFormValidator.city.empty}")
    private String city;
    @Column(name = "country")
    @Length(min = 1, message = "{userFormValidator.country.empty}")
    private String country;
    @Column(name = "houseNumber")
    @Length(min = 1, message = "{userFormValidator.houseNumber.empty}")
    @Pattern(regexp="[0-9]+", message="{userFormValidator.houseNumber.number}")
    private String houseNumber;
    @Column(name = "flatNumber")
    private String flatNumber;
    @Column(name = "phoneNumber")
    @Min(value = 1, message = "{userFormValidator.phoneNumber.empty}")
    private String phoneNumber;
    @Column(name = "additionalPhoneNumber")
    private String additionalPhoneNumber;
    @Column(name = "email")
    @Pattern(regexp=".+@.+\\..+", message="{userFormValidator.email.wrong}")
    private String email;
    @Column(name = "pesel")
    @Pattern(regexp="[0-9]+", message="{userFormValidator.pesel.wrong}")
    private String pesel;
    @Column(name = "zipCode")
    @Pattern(regexp="[0-9]+", message="{userFormValidator.zip.wrong}")
    private String zipCode;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> userRole = new HashSet<UserRole>(0);
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Document> document = new HashSet<Document>(0);

    public User() {
    }

    public boolean isNew() {
        return (this.username == null);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return this.userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(String flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdditionalPhoneNumber() {
        return additionalPhoneNumber;
    }

    public void setAdditionalPhoneNumber(String additionalPhoneNumber) {
        this.additionalPhoneNumber = additionalPhoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Set<Document> getDocument() {
        return document;
    }

    public void setDocument(Set<Document> document) {
        this.document = document;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}