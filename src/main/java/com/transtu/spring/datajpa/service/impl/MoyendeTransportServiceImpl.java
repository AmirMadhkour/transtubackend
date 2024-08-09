package com.transtu.spring.datajpa.service.impl;

import com.transtu.spring.datajpa.model.MoyendeTransport;
import com.transtu.spring.datajpa.repository.MoyendeTransportRepository;
import com.transtu.spring.datajpa.service.MoyendeTransportService;
import com.transtu.spring.datajpa.dtos.MoyendeTransportUpdatedDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoyendeTransportServiceImpl implements MoyendeTransportService {

    @Autowired
    private final MoyendeTransportRepository moyendeTransportRepository;

    public MoyendeTransportServiceImpl(MoyendeTransportRepository moyendeTransportRepository) {
        this.moyendeTransportRepository = moyendeTransportRepository;
    }

    @Override
    public List<MoyendeTransport> getAllMoyendeTransports(String marque) {
        if (marque == null) {
            return moyendeTransportRepository.findAll();
        } else {
            return moyendeTransportRepository.findByMarqueContaining(marque);
        }
    }

    @Override
    public Optional<MoyendeTransport> getMoyendeTransportById(int id) {
        return moyendeTransportRepository.findById(id);
    }

    @Override
    public MoyendeTransport createMoyendeTransport(MoyendeTransport moyendeTransport) {
        return moyendeTransportRepository.save(moyendeTransport);
    }

    @Override
    public Optional<MoyendeTransport> updateMoyendeTransport(int id, MoyendeTransportUpdatedDTO moyendeTransportDTO) {
        Optional<MoyendeTransport> moyendeTransportData = moyendeTransportRepository.findById(id);
        if (moyendeTransportData.isPresent()) {
            MoyendeTransport moyendeTransport = moyendeTransportData.get();
            moyendeTransportDTO.getNumeroDeSerie().ifPresent(moyendeTransport::setNumeroDeSerie);
            moyendeTransportDTO.getMarque().ifPresent(moyendeTransport::setMarque);
            moyendeTransportDTO.getCarburantType().ifPresent(moyendeTransport::setCarburantType);
            moyendeTransportDTO.getOwner().ifPresent(moyendeTransport::setOwner);
            moyendeTransportDTO.getDistrict().ifPresent(moyendeTransport::setDistrict);
            return Optional.of(moyendeTransportRepository.save(moyendeTransport));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteMoyendeTransport(int id) {
        moyendeTransportRepository.deleteById(id);
        
    }

    @Override
    public void deleteAllMoyendeTransports() {
        moyendeTransportRepository.deleteAll();
    }
}
