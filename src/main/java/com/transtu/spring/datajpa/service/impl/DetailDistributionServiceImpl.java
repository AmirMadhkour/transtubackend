package com.transtu.spring.datajpa.service.impl;

import com.transtu.spring.datajpa.dtos.DetailDistributionUpdatedDTO;
import com.transtu.spring.datajpa.model.DetailDistribution;
import com.transtu.spring.datajpa.repository.BonCarburantRepository;
import com.transtu.spring.datajpa.repository.DetailDistributionRepository;
import com.transtu.spring.datajpa.repository.DistributionRepository;
import com.transtu.spring.datajpa.service.DetailDistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DetailDistributionServiceImpl implements DetailDistributionService {

    private final DetailDistributionRepository detailDistributionRepository;
    private final BonCarburantRepository bonCarburantRepository;
    private final DistributionRepository distributionRepository;

    @Autowired
    public DetailDistributionServiceImpl(DetailDistributionRepository detailDistributionRepository, 
                                         BonCarburantRepository bonCarburantRepository, 
                                         DistributionRepository distributionRepository) {
        this.detailDistributionRepository = detailDistributionRepository;
        this.bonCarburantRepository = bonCarburantRepository;
        this.distributionRepository = distributionRepository;
    }

    @Override
    public List<DetailDistribution> getAllDetailDistributions() {
        return detailDistributionRepository.findAll();
    }

    @Override
    public Optional<DetailDistribution> getDetailDistributionById(Long id) {
        return detailDistributionRepository.findById(id);
    }
    
    @Override
    public DetailDistribution createDetailDistribution(DetailDistribution detailDistribution) {
        // Check for null BonCarburant
        if (detailDistribution.getBoncarburant() == null) {
            throw new IllegalStateException("BonCarburant cannot be null");
        }

        // Ensure dateValable is not null
        LocalDate dateValable = detailDistribution.getBoncarburant().getDateValable();
        if (dateValable == null) {
            throw new IllegalStateException("DateValable cannot be null");
        }

        int month = dateValable.getMonthValue();
        int year = dateValable.getYear();

        // Check the count of BonCarburant by month and year
        long count = bonCarburantRepository.countBonCarburantByMonthAndYear(month, year);
        if (count >= 5) {
            throw new IllegalStateException("Limit of 5 boncarburants per month reached");
        }

        // Save the Distribution entity if it's not null and not already saved
        if (detailDistribution.getDistribution() != null && detailDistribution.getDistribution().getId() == 0) {
            detailDistribution.setDistribution(distributionRepository.save(detailDistribution.getDistribution()));
        }

        // Save the DetailDistribution entity
        return detailDistributionRepository.save(new DetailDistribution(
                detailDistribution.getSequence(),
                detailDistribution.getDistribution(),
                detailDistribution.getBoncarburant()
        ));
    }


    @Override
    public Optional<DetailDistribution> updateDetailDistribution(Long id, DetailDistributionUpdatedDTO detailDistributionDTO) {
        Optional<DetailDistribution> detailDistributionData = detailDistributionRepository.findById(id);

        if (detailDistributionData.isPresent()) {
            DetailDistribution _detailDistribution = detailDistributionData.get();

            // Update fields if present in the DTO
            detailDistributionDTO.getSequence().ifPresent(_detailDistribution::setSequence);
            detailDistributionDTO.getDistribution().ifPresent(_detailDistribution::setDistribution);
            detailDistributionDTO.getBoncarburant().ifPresent(_detailDistribution::setBoncarburant);

            // Save the updated entity
            return Optional.of(detailDistributionRepository.save(_detailDistribution));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteDetailDistribution(Long id) {
        detailDistributionRepository.deleteById(id);
    }

    @Override
    public void deleteAllDetailDistributions() {
        detailDistributionRepository.deleteAll();
    }
}
