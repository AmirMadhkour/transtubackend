package com.transtu.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name="detail_distribution")
public class DetailDistribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="sequence")
    private String sequence;

    @ManyToOne
    @JoinColumn(name = "id_distribution", referencedColumnName = "id")
    private Distribution distribution;

    @ManyToOne
    @JoinColumn(name = "id_bon_carburant", referencedColumnName = "idBonCarburant")
    private BonCarburant boncarburant;

    public DetailDistribution() {
    }

    public DetailDistribution(String sequence, Distribution distribution, BonCarburant boncarburant) {
        this.sequence = sequence;
        this.distribution = distribution;
        this.boncarburant = boncarburant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public BonCarburant getBoncarburant() {
        return boncarburant;
    }

    public void setBoncarburant(BonCarburant boncarburant) {
        this.boncarburant = boncarburant;
    }
}
