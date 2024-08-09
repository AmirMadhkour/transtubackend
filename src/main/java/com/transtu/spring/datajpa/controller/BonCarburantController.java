package com.transtu.spring.datajpa.controller;

import com.transtu.spring.datajpa.dtos.BonCarburantUpdatedDTO;
import com.transtu.spring.datajpa.model.BonCarburant;
import com.transtu.spring.datajpa.service.BonCarburantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController

public class BonCarburantController {
	
	@Autowired
    private final BonCarburantService bonCarburantService;

    
    public BonCarburantController(BonCarburantService bonCarburantService) {
        this.bonCarburantService = bonCarburantService;
    }

    @GetMapping("/boncarburants")
    public ResponseEntity<List<BonCarburant>> getAllBonCarburants(@RequestParam(required = false) LocalDate dateValable) {
        try {
            List<BonCarburant> bonCarburants = bonCarburantService.getAllBonCarburants(dateValable);

            if (bonCarburants.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(bonCarburants, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/boncarburants/{id}")
    public ResponseEntity<BonCarburant> getBonCarburantById(@PathVariable("id") int id) {
        Optional<BonCarburant> bonCarburantData = bonCarburantService.getBonCarburantById(id);

        return bonCarburantData.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/boncarburants")
    public ResponseEntity<BonCarburant> createBonCarburant(@RequestBody BonCarburant bonCarburant) {
        try {
            BonCarburant _bonCarburant = bonCarburantService.createBonCarburant(bonCarburant);
            return new ResponseEntity<>(_bonCarburant, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/boncarburants/{id}")
    public ResponseEntity<BonCarburant> updateBonCarburant(@PathVariable("id") int id, @RequestBody  BonCarburantUpdatedDTO bonCarburantDTO) {
        try {
            Optional<BonCarburant> updatedBonCarburant = bonCarburantService.updateBonCarburant(id, bonCarburantDTO);

            return updatedBonCarburant.map(ResponseEntity::ok)
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/boncarburants/{id}")
    public ResponseEntity<HttpStatus> deleteBonCarburant(@PathVariable("id") int id) {
        try {
            bonCarburantService.deleteBonCarburant(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/boncarburants")
    public ResponseEntity<HttpStatus> deleteAllBonCarburants() {
        try {
            bonCarburantService.deleteAllBonCarburants();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
