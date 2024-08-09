package com.transtu.spring.datajpa.controller;

import com.transtu.spring.datajpa.dtos.CarburantTypeUpdatedDTO;
import com.transtu.spring.datajpa.model.CarburantType;
import com.transtu.spring.datajpa.service.CarburantTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController

public class CarburantTypeController {

    @Autowired
    private final  CarburantTypeService carburantTypeService;

    public CarburantTypeController(CarburantTypeService carburantTypeService) {	
    	this.carburantTypeService=carburantTypeService;
    }
    
    @GetMapping("/carburant_types")
    public ResponseEntity<List<CarburantType>> getAllCarburantTypes(@RequestParam(required = false) String label) {
        try {
            List<CarburantType> carburantTypes = carburantTypeService.getAllCarburantTypes(label);

            if (carburantTypes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(carburantTypes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/carburant_types/{id}")
    public ResponseEntity<CarburantType> getCarburantTypeById(@PathVariable("id") long id) {
        Optional<CarburantType> carburantTypeData = carburantTypeService.getCarburantTypeById(id);

        return carburantTypeData.map(carburantType -> new ResponseEntity<>(carburantType, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/carburant_types")
    public ResponseEntity<CarburantType> createCarburantType(@RequestBody CarburantType carburantType) {
        try {
            CarburantType _carburantType = carburantTypeService.createCarburantType(carburantType);
            return new ResponseEntity<>(_carburantType, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/carburant_types/{id}")
    public ResponseEntity<CarburantType> updateCarburantType(@PathVariable("id") long id, @RequestBody CarburantTypeUpdatedDTO carburantTypeDTO) {
        try {
            Optional<CarburantType> updatedCarburantType = carburantTypeService.updateCarburantType(id, carburantTypeDTO);
            return updatedCarburantType.map(ResponseEntity::ok)
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    @DeleteMapping("/carburant_types/{id}")
    public ResponseEntity<HttpStatus> deleteCarburantType(@PathVariable("id") long id) {
        try {
            carburantTypeService.deleteCarburantType(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/carburant_types")
    public ResponseEntity<HttpStatus> deleteAllCarburantTypes() {
        try {
            carburantTypeService.deleteAllCarburantTypes();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
