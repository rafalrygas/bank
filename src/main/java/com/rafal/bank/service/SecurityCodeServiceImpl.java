package com.rafal.bank.service;

import com.rafal.bank.model.SecurityCode;
import com.rafal.bank.repository.SecurityCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class SecurityCodeServiceImpl implements SecurityCodeService {

    @Autowired
    SecurityCodeRepository securityCodeRepository;

    @Autowired
    MailSenderService mailSenderService;

    public void sendCode(Integer id) {
         SecurityCode securityCode = securityCodeRepository.getItem(id);
         mailSenderService.sendSimpleMessage("rrygas@gmail.com","Security code", "Security code for transaction: " + securityCode.getCode());
    }

    public void saveSecurityCode(Integer id) {
        securityCodeRepository.saveItem(id, new SecurityCode(generateSecurityCode(), LocalDateTime.now().plusMinutes(5),0));
    }

    public String generateSecurityCode() {
        StringBuilder stringBuilder = new StringBuilder();
        Random rand = new Random();
        for (int i=0; i<6; i++) {
            stringBuilder.append(rand.nextInt(10));
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean compareCodes(Integer transferId, String securityCode) {
        return securityCodeRepository.getItem(transferId).getCode().equals(securityCode);
    }
}
