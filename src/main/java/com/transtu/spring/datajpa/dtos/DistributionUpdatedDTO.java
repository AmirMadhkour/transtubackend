package com.transtu.spring.datajpa.dtos;

import java.time.LocalDate;
import java.util.Optional;

import com.transtu.spring.datajpa.model.BonCarburant;
import com.transtu.spring.datajpa.model.MoyendeTransport;

public class DistributionUpdatedDTO {

    private Optional<LocalDate> datedistribution;
    private Optional<String> agent;
    private Optional<MoyendeTransport> moyendeTransport;
    private Optional<BonCarburant> bonCarburant; 

    // Default constructor
    public DistributionUpdatedDTO() {
        this.datedistribution = Optional.empty();
        this.agent = Optional.empty();
        this.moyendeTransport = Optional.empty();
        this.bonCarburant = Optional.empty();
    }

    // Parameterized constructor
    public DistributionUpdatedDTO(Optional<LocalDate> datedistribution, Optional<String> agent, Optional<MoyendeTransport> moyendeTransport, Optional<BonCarburant> bonCarburant) {
        this.datedistribution = datedistribution;
        this.agent = agent;
        this.moyendeTransport = moyendeTransport;
        this.bonCarburant = bonCarburant;
    }

    // Getters and setters
    public Optional<LocalDate> getDatedistribution() {
        return datedistribution;
    }

    public void setDatedistribution(Optional<LocalDate> datedistribution) {
        this.datedistribution = datedistribution;
    }

    public Optional<String> getAgent() {
        return agent;
    }

    public void setAgent(Optional<String> agent) {
        this.agent = agent;
    }

    public Optional<MoyendeTransport> getMoyendeTransport() {
        return moyendeTransport;
    }

    public void setMoyendeTransport(Optional<MoyendeTransport> moyendeTransport) {
        this.moyendeTransport = moyendeTransport;
    }

    public Optional<BonCarburant> getBonCarburant() {
        return bonCarburant;
    }

    public void setBonCarburant(Optional<BonCarburant> bonCarburant) {
        this.bonCarburant = bonCarburant;
    }
}
