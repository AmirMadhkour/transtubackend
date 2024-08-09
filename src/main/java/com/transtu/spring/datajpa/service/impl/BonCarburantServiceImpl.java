package com.transtu.spring.datajpa.service.impl;

import com.transtu.spring.datajpa.dtos.BonCarburantUpdatedDTO;
import com.transtu.spring.datajpa.model.BonCarburant;
import com.transtu.spring.datajpa.repository.BonCarburantRepository;
import com.transtu.spring.datajpa.service.BonCarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BonCarburantServiceImpl implements BonCarburantService {
	
	
	@Autowired
    private final BonCarburantRepository bonCarburantRepository;

    
    public BonCarburantServiceImpl(BonCarburantRepository bonCarburantRepository) {
        this.bonCarburantRepository = bonCarburantRepository;
    }

    @Override
    public List<BonCarburant> getAllBonCarburants(LocalDate dateValable) {
        List<BonCarburant> bonCarburants = new ArrayList<>();

        if (dateValable == null) {
            bonCarburantRepository.findAll().forEach(bonCarburants::add);
        } else {
            bonCarburantRepository.findByDateValable(dateValable).forEach(bonCarburants::add);
        }

        return bonCarburants;
    }

    @Override
    public Optional<BonCarburant> getBonCarburantById(int id) {
        return bonCarburantRepository.findById(id);
    }

    @Override
    public BonCarburant createBonCarburant(BonCarburant bonCarburant) {
        return bonCarburantRepository.save(new BonCarburant(
        		bonCarburant.getNumBon(),
        		bonCarburant.getDateValable(),
                bonCarburant.getQuantity(),
                bonCarburant.getValue(),
                bonCarburant.getCarburantType(),
                bonCarburant.getDistrict()
        ));
    }

    @Override
    public Optional<BonCarburant> updateBonCarburant(int id, BonCarburantUpdatedDTO bonCarburantDTO) {
        Optional<BonCarburant> bonCarburantData = bonCarburantRepository.findById(id);

        if (bonCarburantData.isPresent()) {
            BonCarburant _bonCarburant = bonCarburantData.get();

            // Update fields if present in the DTO
            bonCarburantDTO.getNumBon().ifPresent(_bonCarburant::setNumBon);
            bonCarburantDTO.getDateValable().ifPresent(_bonCarburant::setDateValable);
            bonCarburantDTO.getQuantity().ifPresent(_bonCarburant::setQuantity);
            bonCarburantDTO.getValue().ifPresent(_bonCarburant::setValue);
            bonCarburantDTO.getCarburantType().ifPresent(_bonCarburant::setCarburantType);
            bonCarburantDTO.getDistrict().ifPresent(_bonCarburant::setDistrict);
            
            // Save the updated entity
            return Optional.of(bonCarburantRepository.save(_bonCarburant));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public void deleteBonCarburant(int id) {
        bonCarburantRepository.deleteById(id);
    }

    @Override
    public void deleteAllBonCarburants() {
        bonCarburantRepository.deleteAll();
    }
}
