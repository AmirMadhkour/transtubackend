package com.transtu.spring.datajpa.service;

import java.util.List;
import java.util.Optional;

import com.transtu.spring.datajpa.model.Owner;
import com.transtu.spring.datajpa.dtos.OwnerUpdatedDTO;

public interface OwnerService {
    List<Owner> getAllOwners();
    Optional<Owner> getOwnerById(int id);
    Owner createOwner(Owner owner);
    Optional<Owner> updateOwner(int id, OwnerUpdatedDTO ownerUpdatedDTO);
    void deleteOwner(int id);
    void deleteAllOwners();
}
