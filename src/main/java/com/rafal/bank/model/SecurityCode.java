package com.rafal.bank.model;

import java.time.LocalDateTime;

public class SecurityCode {

    private String code;
    private LocalDateTime timeExpired;
    private int attempts;

    public SecurityCode() {
    }

    public SecurityCode(String code, LocalDateTime timeExpired, int attempts) {
        this.code = code;
        this.timeExpired = timeExpired;
        this.attempts = attempts;
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

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    @Override
    public String toString() {
        return "SecurityCode{" +
                "code='" + code + '\'' +
                ", timeExpired=" + timeExpired +
                ", attempts=" + attempts +
                '}';
    }
}
