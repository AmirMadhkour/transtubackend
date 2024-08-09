package com.transtu.spring.datajpa.service;

import com.transtu.spring.datajpa.model.District;
import com.transtu.spring.datajpa.dtos.DistrictUpdatedDTO;

import java.util.List;
import java.util.Optional;

public interface DistrictService {

    // Retrieve all districts
    List<District> getAllDistricts();

    // Retrieve a district by ID
    Optional<District> getDistrictById(Long id);

    // Create a new district
    District createDistrict(District district);

    // Update an existing district
    Optional<District> updateDistrict(Long id, DistrictUpdatedDTO updatedDTO);

    // Delete a district by ID
    void deleteDistrict(Long id);
    
    //Delete all 
    void deleteAllDistrict();
}
