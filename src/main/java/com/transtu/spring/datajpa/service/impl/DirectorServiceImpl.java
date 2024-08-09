package com.transtu.spring.datajpa.service.impl;


import com.transtu.spring.datajpa.dtos.DirectorUpdatedDTO;
import com.transtu.spring.datajpa.model.Director;
import com.transtu.spring.datajpa.repository.DirectorRepository;
import com.transtu.spring.datajpa.service.DirectorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
public class DirectorServiceImpl implements DirectorService {
	
	@Autowired
   private final DirectorRepository directorRepository;
	
	public DirectorServiceImpl(DirectorRepository directorRepository) {
		this.directorRepository=directorRepository;
	}
	
	@Override
    public List<Director> getAllDirectors() {
        return directorRepository.findAll();
    }

    @Override
    public Optional<Director> getDirectorById(Long id) {
        return directorRepository.findById(id);
    }

    @Override
    public Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    @Override
    public Optional<Director> updateDirector(Long id, DirectorUpdatedDTO directorDetailsDTO) {
        Optional<Director> optionalDirector = directorRepository.findById(id);

        if (optionalDirector.isPresent()) {
            Director existingDirector = optionalDirector.get();

            // Update fields if present in the DTO
            directorDetailsDTO.getLabel().ifPresent(existingDirector::setLabel);
            directorDetailsDTO.getTelephone().ifPresent(existingDirector::setTelephone);
            directorDetailsDTO.getEmail().ifPresent(existingDirector::setEmail);
            directorDetailsDTO.getAddress().ifPresent(existingDirector::setAddress);

            // Save the updated entity
            return Optional.of(directorRepository.save(existingDirector));
        } else {
            return Optional.empty();
        }
    }


    @Override
    public void deleteDirector(Long id) {
        directorRepository.deleteById(id);
    }
    
    @Override
    public void deleteAllDirectors() {
        directorRepository.deleteAll();
    }
	
	

}
