package com.transtu.spring.datajpa.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bon_carburant")
public class BonCarburant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBonCarburant;
    
    @Column(name = "num_bon")
    private Long numBon;

    @Column(name = "date_valable")
    private LocalDate dateValable;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "value")
    private String value;
    
    @ManyToOne
    @JoinColumn(name = "idCarburantType", referencedColumnName = "idCarburantType")
    private CarburantType carburantType;
    
    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id")
    private District district;


    // Constructors
    public BonCarburant() {
    }

    public BonCarburant(Long numBon, LocalDate dateValable, String quantity, String value, CarburantType carburantType , District district) {
        this.numBon = numBon;
        this.dateValable = dateValable;
        this.quantity = quantity;
        this.value = value;
        this.carburantType = carburantType;
        this.district = district ;
    }

    // Getters and setters
    
    public District getDistrict() {
    	return district;
    }
    
    public void setDistrict(District district ) {
    	this.district = district;
    }
    public int getIdBonCarburant() {
        return idBonCarburant;
    }

    public void setIdBonCarburant(int idBonCarburant) {
        this.idBonCarburant = idBonCarburant;
    }

    public Long getNumBon() {
        return numBon;
    }

    public void setNumBon(Long numBon) {
        this.numBon = numBon;
    }

    public LocalDate getDateValable() {
        return dateValable;
    }

    public void setDateValable(LocalDate dateValable) {
        this.dateValable = dateValable;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public CarburantType getCarburantType() {
        return carburantType;
    }

    public void setCarburantType(CarburantType carburantType) {
        this.carburantType = carburantType;
    }
}
