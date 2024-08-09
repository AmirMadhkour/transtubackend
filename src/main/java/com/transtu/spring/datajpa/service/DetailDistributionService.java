package com.transtu.spring.datajpa.service;

import com.transtu.spring.datajpa.dtos.DetailDistributionUpdatedDTO;
import com.transtu.spring.datajpa.model.DetailDistribution;

import java.util.List;
import java.util.Optional;

public interface DetailDistributionService {

    List<DetailDistribution> getAllDetailDistributions();
    Optional<DetailDistribution> getDetailDistributionById(Long id);
    DetailDistribution createDetailDistribution(DetailDistribution detailDistribution);
    Optional<DetailDistribution> updateDetailDistribution(Long id, DetailDistributionUpdatedDTO detailDistributionDTO);
    void deleteDetailDistribution(Long id);
    void deleteAllDetailDistributions();
}
