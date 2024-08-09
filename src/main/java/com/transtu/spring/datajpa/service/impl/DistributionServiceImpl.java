package com.transtu.spring.datajpa.service.impl;


import com.transtu.spring.datajpa.dtos.DistributionUpdatedDTO;
import com.transtu.spring.datajpa.model.Distribution;
import com.transtu.spring.datajpa.repository.DistributionRepository;
import com.transtu.spring.datajpa.service.DistributionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class DistributionServiceImpl implements DistributionService {

    @Autowired
    private final DistributionRepository distributionRepository;

    public DistributionServiceImpl(DistributionRepository distributionRepository) {
    	this.distributionRepository=distributionRepository;
    }
    
    @Override
    public List<Distribution> getAllDistributions(LocalDate datedistribution) {
        if (datedistribution == null) {
            return distributionRepository.findAll();
        } else {
            return distributionRepository.findByDatedistribution(datedistribution);
        }
    }

    @Override
    public Optional<Distribution> getDistributionById(Long id) {
        return distributionRepository.findById(id);
    }

    @Override
    public Distribution createDistribution(Distribution distribution) {
        return distributionRepository.save(new Distribution(
                distribution.getDate(),
                distribution.getAgent(),
                distribution.getMoyendeTransport(),
                distribution.getBonCarburant()
        ));
    }

    @Override
    public Optional<Distribution> updateDistribution(Long id, DistributionUpdatedDTO distributionUpdatedDTO) {
        Optional<Distribution> distributionData = distributionRepository.findById(id);

        if (distributionData.isPresent()) {
            Distribution _distribution = distributionData.get();

            // Update fields if present in the DTO
            distributionUpdatedDTO.getDatedistribution().ifPresent(_distribution::setDate);
            distributionUpdatedDTO.getAgent().ifPresent(_distribution::setAgent);
            distributionUpdatedDTO.getMoyendeTransport().ifPresent(_distribution::setMoyendeTransport);
            distributionUpdatedDTO.getBonCarburant().ifPresent(_distribution::setBonCarburant);

            // Save the updated entity
            return Optional.of(distributionRepository.save(_distribution));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public void deleteDistribution(Long id) {
        distributionRepository.deleteById(id);
    }

    @Override
    public void deleteAllDistributions() {
        distributionRepository.deleteAll();
    }
}

