package com.transtu.spring.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.transtu.spring.datajpa.dtos.DetailDistributionUpdatedDTO;
import com.transtu.spring.datajpa.model.DetailDistribution;
import com.transtu.spring.datajpa.service.DetailDistributionService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController

public class DetailDistributionController {

    @Autowired
    private final DetailDistributionService detailDistributionService;

    public DetailDistributionController(DetailDistributionService detailDistributionService) {
        this.detailDistributionService = detailDistributionService;
    }

    @GetMapping("/detail_distribution")
    public ResponseEntity<List<DetailDistribution>> getAllDetailDistributions() {
        try {
            List<DetailDistribution> detailDistributions = detailDistributionService.getAllDetailDistributions();
            if (detailDistributions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(detailDistributions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/detail_distribution/{id}")
    public ResponseEntity<DetailDistribution> getDetailDistributionById(@PathVariable("id") Long id) {
        Optional<DetailDistribution> detailDistributionData = detailDistributionService.getDetailDistributionById(id);
        return detailDistributionData.map(distribution -> new ResponseEntity<>(distribution, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/detail_distribution")
    public ResponseEntity<DetailDistribution> createDetailDistribution(@RequestBody DetailDistribution detailDistribution) {
        try {
            DetailDistribution _detailDistribution = detailDistributionService.createDetailDistribution(detailDistribution);
            return new ResponseEntity<>(_detailDistribution, HttpStatus.CREATED);
        } catch (IllegalStateException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace(); // Log the exception for debugging
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping("/detail_distribution/{id}")
    public ResponseEntity<DetailDistribution> updateDetailDistribution(@PathVariable("id") Long id, @RequestBody DetailDistributionUpdatedDTO detailDistributionDTO) {
        Optional<DetailDistribution> detailDistributionData = detailDistributionService.updateDetailDistribution(id, detailDistributionDTO);
        return detailDistributionData.map(distribution -> new ResponseEntity<>(distribution, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/detail_distribution/{id}")
    public ResponseEntity<HttpStatus> deleteDetailDistribution(@PathVariable("id") Long id) {
        try {
            detailDistributionService.deleteDetailDistribution(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/detail_distribution")
    public ResponseEntity<HttpStatus> deleteAllDetailDistributions() {
        try {
            detailDistributionService.deleteAllDetailDistributions();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
