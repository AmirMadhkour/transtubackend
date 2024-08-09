package com.transtu.spring.datajpa.dtos;

import java.util.Optional;

import com.transtu.spring.datajpa.model.BonCarburant;
import com.transtu.spring.datajpa.model.Distribution;

public class DetailDistributionUpdatedDTO {

    private Optional<String> sequence;
    private Optional<Distribution> distribution;
    private Optional<BonCarburant> boncarburant;

    // Default constructor
    public DetailDistributionUpdatedDTO() {
        this.sequence = Optional.empty();
        this.distribution = Optional.empty();
        this.boncarburant = Optional.empty();
    }

    // Parameterized constructor
    public DetailDistributionUpdatedDTO(Optional<String> sequence, Optional<Distribution> distribution, Optional<BonCarburant> boncarburant) {
        this.sequence = sequence;
        this.distribution = distribution;
        this.boncarburant = boncarburant;
    }

    // Getters and setters
    public Optional<String> getSequence() {
        return sequence;
    }

    public void setSequence(Optional<String> sequence) {
        this.sequence = sequence;
    }

   

    public Optional<Distribution> getDistribution() {
        return distribution;
    }

    public void setDistribution(Optional<Distribution> distribution) {
        this.distribution = distribution;
    }

    
    public Optional<BonCarburant> getBoncarburant() {
        return boncarburant;
    }

    public void setBoncarburant(Optional<BonCarburant> boncarburant) {
        this.boncarburant = boncarburant;
    }

}    
