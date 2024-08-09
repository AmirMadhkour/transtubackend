package com.transtu.spring.datajpa.service;

import com.transtu.spring.datajpa.dtos.CarburantTypeUpdatedDTO;
import com.transtu.spring.datajpa.model.CarburantType;

import java.util.List;
import java.util.Optional;

public interface CarburantTypeService {
    List<CarburantType> getAllCarburantTypes(String label);
    Optional<CarburantType> getCarburantTypeById(long id);
    CarburantType createCarburantType(CarburantType carburantType);
    Optional<CarburantType> updateCarburantType(long id, CarburantTypeUpdatedDTO carburantTypeDTO);
    void deleteCarburantType(long id);
    void deleteAllCarburantTypes();
}
