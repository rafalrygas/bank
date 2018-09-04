package com.rafal.bank.repository;

import com.rafal.bank.model.SecurityCode;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class SecurityCodeRepositoryImpl implements SecurityCodeRepository {

    private Map<Integer, SecurityCode> securityCodeMap = new HashMap<Integer, SecurityCode>();

}
