package com.rafal.bank.service;

public interface MailSenderService {
    public void sendSimpleMessage(
            String to, String subject, String text);
}
