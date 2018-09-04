package com.rafal.bank.repository;

import com.rafal.bank.model.Transfer;

import java.util.List;

public interface TransferRepository {
    Transfer findById(Integer id);

    List<Transfer> findAll();

    Integer save(Transfer transfer);

    void update(Transfer transfer);

    void delete(Integer id);
}
