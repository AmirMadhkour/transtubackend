package com.transtu.spring.datajpa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.transtu.spring.datajpa.model.Director;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    List<Director> findByLabelContaining(String label);
}
