package com.transtu.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "moyen_de_transport")
public class MoyendeTransport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @Column(name = "numero_de_serie")
    private String numeroDeSerie; 

    @Column(name = "marque")
    private String marque;

    @ManyToOne
    @JoinColumn(name = "id_carburant_type", referencedColumnName = "idCarburantType")
    private CarburantType carburantType;

    @ManyToOne
    @JoinColumn(name = "id_owner", referencedColumnName = "id")
    private Owner owner;
    
    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id")
    private District district;

    public MoyendeTransport() {
    }

    public MoyendeTransport(String numeroDeSerie, String marque, CarburantType carburantType, Owner owner , District district) {
        this.numeroDeSerie = numeroDeSerie;
        this.marque = marque;
        this.carburantType = carburantType;
        this.owner = owner;
        this.district = district ;
    }

    // Getters and setters
    
    public District getDistrict() {
    	return district;
    }
    
    public void setDistrict(District district ) {
    	this.district = district;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public CarburantType getCarburantType() {
        return carburantType;
    }

    public void setCarburantType(CarburantType carburantType) {
        this.carburantType = carburantType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
