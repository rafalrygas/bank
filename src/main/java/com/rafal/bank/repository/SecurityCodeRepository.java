package com.rafal.bank.repository;

import com.rafal.bank.model.SecurityCode;

public interface SecurityCodeRepository {
    SecurityCode getItem(Integer id);
    void saveItem(Integer id, SecurityCode securityCode);
}
