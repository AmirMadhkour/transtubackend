package com.transtu.spring.datajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.transtu.spring.datajpa.model.UserGeneral;
import java.util.Optional;

public interface UserGeneralRepository extends JpaRepository<UserGeneral, Long> {
    List<UserGeneral> findByLoginContaining(String login);
    Optional<UserGeneral> findByLogin(String login);

}
