package com.transtu.spring.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.transtu.spring.datajpa.dtos.DirectorUpdatedDTO;
import com.transtu.spring.datajpa.model.Director;
import com.transtu.spring.datajpa.service.DirectorService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController

public class DirectorController {

    @Autowired
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/director")
    public ResponseEntity<List<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return ResponseEntity.ok(directors);
    }

    @GetMapping("/director/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable("id") Long id) {
        Optional<Director> directorOptional = directorService.getDirectorById(id);
        return directorOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/director")
    public ResponseEntity<Director> createDirector(@RequestBody Director director) {
        Director createdDirector = directorService.createDirector(director);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDirector);
    }

    @PatchMapping("/director/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable("id") Long id, @RequestBody DirectorUpdatedDTO directorUpdatedDTO) {
        Optional<Director> optionalDirector = directorService.updateDirector(id, directorUpdatedDTO);
        return optionalDirector.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/director/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable("id") Long id) {
        directorService.deleteDirector(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/director")
    public ResponseEntity<Void> deleteAllDirectors() {
        directorService.deleteAllDirectors();
        return ResponseEntity.noContent().build();
    }
}
