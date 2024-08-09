package com.transtu.spring.datajpa.service;

import com.transtu.spring.datajpa.dtos.BonCarburantUpdatedDTO;
import com.transtu.spring.datajpa.model.BonCarburant;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BonCarburantService {
    List<BonCarburant> getAllBonCarburants(LocalDate dateValable);
    Optional<BonCarburant> getBonCarburantById(int id);
    BonCarburant createBonCarburant(BonCarburant bonCarburant);
    Optional<BonCarburant> updateBonCarburant(int id, BonCarburantUpdatedDTO bonCarburantDTO);
    void deleteBonCarburant(int id);
    void deleteAllBonCarburants();
}
