package com.rafal.bank.service;

public interface SecurityCodeService {
    void sendCode(Integer id);
    void saveSecurityCode(Integer id);
    String generateSecurityCode();

    boolean compareCodes(Integer transferId, String securityCode);
}
