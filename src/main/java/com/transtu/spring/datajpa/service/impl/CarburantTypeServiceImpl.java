package com.transtu.spring.datajpa.service.impl;

import com.transtu.spring.datajpa.dtos.CarburantTypeUpdatedDTO;
import com.transtu.spring.datajpa.model.CarburantType;
import com.transtu.spring.datajpa.repository.CarburantTypeRepository;
import com.transtu.spring.datajpa.service.CarburantTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarburantTypeServiceImpl implements CarburantTypeService {

    @Autowired
    private final CarburantTypeRepository carburantTypeRepository;

    public CarburantTypeServiceImpl( CarburantTypeRepository carburantTypeRepository) {
    	this.carburantTypeRepository=carburantTypeRepository;
    }
    @Override
    public List<CarburantType> getAllCarburantTypes(String label) {
        List<CarburantType> carburantTypes = new ArrayList<>();

        if (label == null) {
            carburantTypeRepository.findAll().forEach(carburantTypes::add);
        } else {
            carburantTypeRepository.findByLabelContaining(label).forEach(carburantTypes::add);
        }

        return carburantTypes;
    }

    @Override
    public Optional<CarburantType> getCarburantTypeById(long id) {
        return carburantTypeRepository.findById(id);
    }

    @Override
    public CarburantType createCarburantType(CarburantType carburantType) {
        return carburantTypeRepository.save(new CarburantType(carburantType.getLabel()));
    }

    @Override
    public Optional<CarburantType> updateCarburantType(long id, CarburantTypeUpdatedDTO carburantTypeDTO) {
        Optional<CarburantType> carburantTypeData = carburantTypeRepository.findById(id);

        if (carburantTypeData.isPresent()) {
            CarburantType _carburantType = carburantTypeData.get();

            // Update label if present in DTO
            carburantTypeDTO.getLabel().ifPresent(_carburantType::setLabel);

            // Save the updated entity
            return Optional.of(carburantTypeRepository.save(_carburantType));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public void deleteCarburantType(long id) {
        carburantTypeRepository.deleteById(id);
    }

    @Override
    public void deleteAllCarburantTypes() {
        carburantTypeRepository.deleteAll();
    }
}
