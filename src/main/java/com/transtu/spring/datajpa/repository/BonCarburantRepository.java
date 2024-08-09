package com.transtu.spring.datajpa.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.transtu.spring.datajpa.model.BonCarburant;

public interface BonCarburantRepository extends JpaRepository<BonCarburant, Integer> {

    List<BonCarburant> findByDateValable(LocalDate dateValable);
   
   

    @Query("SELECT COUNT(b) FROM BonCarburant b WHERE MONTH(b.dateValable) = :month AND YEAR(b.dateValable) = :year")
    long countBonCarburantByMonthAndYear(@Param("month") int month, @Param("year") int year);
}
