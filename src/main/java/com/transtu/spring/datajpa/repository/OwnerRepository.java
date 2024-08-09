package com.transtu.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transtu.spring.datajpa.model.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {
    // Define custom query methods if needed
}
