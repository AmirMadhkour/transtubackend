package com.transtu.spring.datajpa.service;

import com.transtu.spring.datajpa.dtos.DistributionUpdatedDTO;
import com.transtu.spring.datajpa.model.Distribution;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DistributionService {

	List<Distribution> getAllDistributions(LocalDate datedistribution);
    Optional<Distribution> getDistributionById(Long id);
    Distribution createDistribution(Distribution distribution);
    Optional<Distribution> updateDistribution(Long id, DistributionUpdatedDTO distributionUpdatedDTO);
    void deleteDistribution(Long id);
    void deleteAllDistributions();
	
}
