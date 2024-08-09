package com.transtu.spring.datajpa.controller;

import com.transtu.spring.datajpa.model.MoyendeTransport;
import com.transtu.spring.datajpa.service.MoyendeTransportService;
import com.transtu.spring.datajpa.dtos.MoyendeTransportUpdatedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")

@RestController
public class MoyendeTransportController {

    @Autowired
    private final MoyendeTransportService moyendeTransportService;

    public MoyendeTransportController(MoyendeTransportService moyendeTransportService) {
        this.moyendeTransportService = moyendeTransportService;
    }

    @GetMapping("/moyendeTransports")
    public ResponseEntity<List<MoyendeTransport>> getAllMoyendeTransports(@RequestParam(required = false) String marque) {
        try {
            List<MoyendeTransport> moyendeTransports = moyendeTransportService.getAllMoyendeTransports(marque);

            if (moyendeTransports.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(moyendeTransports, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/moyendeTransports/{id}")
    public ResponseEntity<MoyendeTransport> getMoyendeTransportById(@PathVariable("id") int id) {
        Optional<MoyendeTransport> moyendeTransportData = moyendeTransportService.getMoyendeTransportById(id);

        return moyendeTransportData.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/moyendeTransports")
    public ResponseEntity<MoyendeTransport> createMoyendeTransport(@RequestBody MoyendeTransport moyendeTransport) {
        try {
            MoyendeTransport _moyendeTransport = moyendeTransportService.createMoyendeTransport(moyendeTransport);
            return new ResponseEntity<>(_moyendeTransport, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/moyendeTransports/{id}")
    public ResponseEntity<MoyendeTransport> updateMoyendeTransport(@PathVariable("id") int id, @RequestBody MoyendeTransportUpdatedDTO moyendeTransportDTO) {
        Optional<MoyendeTransport> updatedMoyendeTransport = moyendeTransportService.updateMoyendeTransport(id, moyendeTransportDTO);

        return updatedMoyendeTransport.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/moyendeTransports/{id}")
    public ResponseEntity<HttpStatus> deleteMoyendeTransport(@PathVariable("id") int id) {
        try {
            moyendeTransportService.deleteMoyendeTransport(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/moyendeTransports")
    public ResponseEntity<HttpStatus> deleteAllMoyendeTransports() {
        try {
            moyendeTransportService.deleteAllMoyendeTransports();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
