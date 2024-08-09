package com.transtu.spring.datajpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.transtu.spring.datajpa.service.OwnerService;
import com.transtu.spring.datajpa.dtos.OwnerUpdatedDTO;
import com.transtu.spring.datajpa.model.Owner;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class OwnerController {

    @Autowired
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/owner")
    public ResponseEntity<List<Owner>> getAllOwners() {
        try {
            List<Owner> owners = ownerService.getAllOwners();
            if (owners.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(owners, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<Owner> getOwnerById(@PathVariable("id") int id) {
        Optional<Owner> ownerData = ownerService.getOwnerById(id);
        return ownerData.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    
    @PostMapping("/owner")
    public ResponseEntity<Owner> createOwner(@RequestBody Owner owner) {
        try {
            Owner _owner = ownerService.createOwner(owner);
            return new ResponseEntity<>(_owner, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/owner/{id}")
    public ResponseEntity<Owner> updateOwner(@PathVariable("id") int id, @RequestBody OwnerUpdatedDTO ownerUpdatedDTO) {
        Optional<Owner> updatedOwner = ownerService.updateOwner(id, ownerUpdatedDTO);
        return updatedOwner.map(owner -> new ResponseEntity<>(owner, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/owner/{id}")
    public ResponseEntity<HttpStatus> deleteOwner(@PathVariable("id") int id) {
        try {
            ownerService.deleteOwner(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/owner")
    public ResponseEntity<HttpStatus> deleteAllOwners() {
        try {
            ownerService.deleteAllOwners();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
