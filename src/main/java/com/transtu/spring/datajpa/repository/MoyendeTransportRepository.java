package com.transtu.spring.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transtu.spring.datajpa.model.MoyendeTransport;

import java.util.List;

public interface MoyendeTransportRepository extends JpaRepository<MoyendeTransport, Integer> {
    List<MoyendeTransport> findByMarqueContaining(String marque);
}
