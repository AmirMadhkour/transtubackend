package com.transtu.spring.datajpa.controller;

import com.transtu.spring.datajpa.dtos.DistributionUpdatedDTO;
import com.transtu.spring.datajpa.model.Distribution;
import com.transtu.spring.datajpa.service.DistributionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController

public class DistributionController {

    @Autowired
    public final DistributionService distributionService;

    public DistributionController (DistributionService distributionService) {
    	this.distributionService=distributionService;
    }
    
    @GetMapping("/distributions")
    public ResponseEntity<List<Distribution>> getAllDistributions(@RequestParam(required = false) LocalDate datedistribution) {
        try {
            List<Distribution> distributions = distributionService.getAllDistributions(datedistribution);

            if (distributions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(distributions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/distributions/{id}")
    public ResponseEntity<Distribution> getDistributionById(@PathVariable("id") Long id) {
        Optional<Distribution> distributionData = distributionService.getDistributionById(id);

        return distributionData.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/distribution")
    public ResponseEntity<Distribution> createDistribution(@RequestBody Distribution distribution) {
        try {
            Distribution _distribution = distributionService.createDistribution(distribution);
            return new ResponseEntity<>(_distribution, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/distributions/{id}")
    public ResponseEntity<Distribution> updateDistribution(@PathVariable("id") Long id, @RequestBody DistributionUpdatedDTO distributionUpdatedDTO) {
        Optional<Distribution> updatedDistribution = distributionService.updateDistribution(id, distributionUpdatedDTO);

        if (updatedDistribution.isPresent()) {
            return new ResponseEntity<>(updatedDistribution.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/distributions/{id}")
    public ResponseEntity<HttpStatus> deleteDistribution(@PathVariable("id") Long id) {
        try {
            distributionService.deleteDistribution(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/distributions")
    public ResponseEntity<HttpStatus> deleteAllDistributions() {
        try {
            distributionService.deleteAllDistributions();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
