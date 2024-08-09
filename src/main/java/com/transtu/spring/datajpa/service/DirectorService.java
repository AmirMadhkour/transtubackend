package com.transtu.spring.datajpa.service;

import com.transtu.spring.datajpa.dtos.DirectorUpdatedDTO;
import com.transtu.spring.datajpa.model.Director;

import java.util.List;
import java.util.Optional;

public interface DirectorService {
    List<Director> getAllDirectors();
    Optional<Director> getDirectorById(Long id);
    Director createDirector(Director director);
    Optional<Director> updateDirector(Long id, DirectorUpdatedDTO directorUpdatedDTO);
    void deleteDirector(Long id);
    void deleteAllDirectors();  

}
