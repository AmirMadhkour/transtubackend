package com.transtu.spring.datajpa.controller;

import com.transtu.spring.datajpa.model.District;
import com.transtu.spring.datajpa.dtos.DistrictUpdatedDTO;
import com.transtu.spring.datajpa.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class DistrictController {

    @Autowired
    private final DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping("/districts")
    public ResponseEntity<List<District>> getAllDistricts() {
        try {
            List<District> districts = districtService.getAllDistricts();

            if (districts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(districts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/districts/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable("id") Long id) {
        Optional<District> districtData = districtService.getDistrictById(id);

        return districtData.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/districts")
    public ResponseEntity<District> createDistrict(@RequestBody District district) {
        try {
            District _district = districtService.createDistrict(district);
            return new ResponseEntity<>(_district, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/districts/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable("id") Long id, @RequestBody DistrictUpdatedDTO updatedDTO) {
        Optional<District> updatedDistrict = districtService.updateDistrict(id, updatedDTO);

        return updatedDistrict.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/districts/{id}")
    public ResponseEntity<HttpStatus> deleteDistrict(@PathVariable("id") Long id) {
        try {
            districtService.deleteDistrict(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/districts")
    public ResponseEntity<HttpStatus> deleteAllDistricts() {
        try {
            districtService.deleteAllDistrict();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
