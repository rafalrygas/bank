package com.rafal.bank.service;

import com.rafal.bank.repository.SecurityCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityCodeServiceImpl implements SecurityCodeService {

    @Autowired
    SecurityCodeRepository securityCodeRepository;

    @Autowired
    MailSenderService mailSenderService;

    public void sendCode() {
         mailSenderService.sendSimpleMessage("rrygas@gmail.com","test", "1");
    }
}
