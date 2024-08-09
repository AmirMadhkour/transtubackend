package com.transtu.spring.datajpa.service.impl;

import java.util.List;
import java.util.Optional;

import com.transtu.spring.datajpa.model.Owner;
import com.transtu.spring.datajpa.dtos.OwnerUpdatedDTO;
import com.transtu.spring.datajpa.service.OwnerService;
import com.transtu.spring.datajpa.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public Optional<Owner> getOwnerById(int id) {
        return ownerRepository.findById(id);
    }

    @Override
    public Owner createOwner(Owner owner) {
        return ownerRepository.save(new Owner(
                owner.getFullName(),
                owner.getMatricule(),
                owner.getTelephone(),
                owner.getEmail(),
                owner.getDirector()
        ));
    }

    @Override
    public Optional<Owner> updateOwner(int id, OwnerUpdatedDTO ownerUpdatedDTO) {
        Optional<Owner> ownerData = ownerRepository.findById(id);
        if (ownerData.isPresent()) {
            Owner existingOwner = ownerData.get();

            // Update fields only if they are present in the DTO
            ownerUpdatedDTO.getFullName().ifPresent(existingOwner::setFullName);
            ownerUpdatedDTO.getMatricule().ifPresent(existingOwner::setMatricule);
            ownerUpdatedDTO.getTelephone().ifPresent(existingOwner::setTelephone);
            ownerUpdatedDTO.getEmail().ifPresent(existingOwner::setEmail);
            ownerUpdatedDTO.getDirector().ifPresent(existingOwner::setDirector);

            return Optional.of(ownerRepository.save(existingOwner));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteOwner(int id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public void deleteAllOwners() {
        ownerRepository.deleteAll();
    }
}
