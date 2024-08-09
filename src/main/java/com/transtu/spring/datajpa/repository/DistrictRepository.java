package com.transtu.spring.datajpa.repository;

import com.transtu.spring.datajpa.model.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

   
}
