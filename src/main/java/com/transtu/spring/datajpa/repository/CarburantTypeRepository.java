package com.transtu.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transtu.spring.datajpa.model.CarburantType;

public interface CarburantTypeRepository extends JpaRepository<CarburantType, Long> {
    List<CarburantType> findByLabelContaining(String label);
}
