package com.rafal.bank.model;

import java.time.LocalDateTime;

public class SecurityCode {

    private String code;
    private LocalDateTime timeExpired;

    public SecurityCode() {
    }

    public SecurityCode(String code, LocalDateTime timeExpired) {
        this.code = code;
        this.timeExpired = timeExpired;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getTimeExpired() {
        return timeExpired;
    }

    public void setTimeExpired(LocalDateTime timeExpired) {
        this.timeExpired = timeExpired;
    }

    @Override
    public String toString() {
        return "SecurityCode{" +
                "code='" + code + '\'' +
                ", timeExpired=" + timeExpired +
                '}';
    }
}
