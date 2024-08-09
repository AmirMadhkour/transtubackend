package com.transtu.spring.datajpa.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name="distribution")
public class Distribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="date_distribution")
    private LocalDate datedistribution;

    @Column(name="agent")
    private String agent;

    @ManyToOne
    @JoinColumn(name = "id_moyende_transport", referencedColumnName = "id")
    private MoyendeTransport moyendeTransport;
    
    @ManyToOne
    @JoinColumn(name = "id_bon_carburant", referencedColumnName = "idBonCarburant")
    private BonCarburant bonCarburant;
    
    public Distribution() {
    }

    public Distribution(LocalDate date, String agent, MoyendeTransport moyendeTransport, BonCarburant bonCarburant) {
        this.datedistribution = date;
        this.agent = agent;
        this.moyendeTransport = moyendeTransport;
        this.bonCarburant = bonCarburant;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return datedistribution;
    }

    public void setDate(LocalDate date) {
        this.datedistribution = date;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public MoyendeTransport getMoyendeTransport() {
        return moyendeTransport;
    }

    public void setMoyendeTransport(MoyendeTransport moyendeTransport) {
        this.moyendeTransport = moyendeTransport;
    }

    public BonCarburant getBonCarburant() {
        return bonCarburant;
    }

    public void setBonCarburant(BonCarburant bonCarburant) {
        this.bonCarburant = bonCarburant;
    }
}
