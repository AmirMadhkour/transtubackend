package com.transtu.spring.datajpa.service;

import com.transtu.spring.datajpa.model.MoyendeTransport;
import com.transtu.spring.datajpa.dtos.MoyendeTransportUpdatedDTO;

import java.util.List;
import java.util.Optional;

public interface MoyendeTransportService {

    List<MoyendeTransport> getAllMoyendeTransports(String marque);

    Optional<MoyendeTransport> getMoyendeTransportById(int id);

    MoyendeTransport createMoyendeTransport(MoyendeTransport moyendeTransport);

    Optional<MoyendeTransport> updateMoyendeTransport(int id, MoyendeTransportUpdatedDTO moyendeTransportDTO);

    void deleteMoyendeTransport(int id);

    void deleteAllMoyendeTransports();
}
