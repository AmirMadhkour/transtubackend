package com.transtu.spring.datajpa.service.impl;

import com.transtu.spring.datajpa.model.District;
import com.transtu.spring.datajpa.dtos.DistrictUpdatedDTO;
import com.transtu.spring.datajpa.repository.DistrictRepository;
import com.transtu.spring.datajpa.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
	
	@Autowired
    private final DistrictRepository districtRepository;

   
    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    @Override
    public Optional<District> getDistrictById(Long id) {
        return districtRepository.findById(id);
    }

    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    @Override
    public Optional<District> updateDistrict(Long id, DistrictUpdatedDTO updatedDTO) {
        return districtRepository.findById(id).map(existingDistrict -> {
            updatedDTO.getCode().ifPresent(existingDistrict::setCode);
            updatedDTO.getLib().ifPresent(existingDistrict::setLib);
            return districtRepository.save(existingDistrict);
        });
    }

    @Override
    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }
    
    @Override
    public void deleteAllDistrict() {
        districtRepository.deleteAll();
    }
}
