package com.transtu.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transtu.spring.datajpa.model.DetailDistribution;

@Repository
public interface DetailDistributionRepository extends JpaRepository<DetailDistribution, Long> {
}
