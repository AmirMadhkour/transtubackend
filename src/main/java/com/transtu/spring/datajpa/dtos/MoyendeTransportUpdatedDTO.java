package com.transtu.spring.datajpa.dtos;

import java.util.Optional;

import com.transtu.spring.datajpa.model.CarburantType;
import com.transtu.spring.datajpa.model.Owner;
import com.transtu.spring.datajpa.model.District;

public class MoyendeTransportUpdatedDTO {

    private Optional<String> numeroDeSerie = Optional.empty(); 
    private Optional<String> marque = Optional.empty();
    private Optional<CarburantType> carburantType = Optional.empty();
    private Optional<Owner> owner = Optional.empty();
    private Optional<District> district =  Optional.empty();

    // Default constructor
    public MoyendeTransportUpdatedDTO() {}

    // Parameterized constructor
    public MoyendeTransportUpdatedDTO(Optional<String> numeroDeSerie , Optional<String> marque, Optional<CarburantType> carburantType , Optional<Owner> owner , Optional<District> district) {
        this.numeroDeSerie = numeroDeSerie;
        this.marque = marque;
        this.carburantType = carburantType;
        this.owner = owner;
        this.district = district ; 
    }

    // Getters and Setters
    public Optional<District>  getDistrict() {
    	return district;
    }
    
    public void setDistrict(Optional<District>  district ) {
    	this.district = district;
    }
    
    public Optional<String> getNumeroDeSerie() {
        return numeroDeSerie;
    }

    public void setNumeroDeSerie(Optional<String> numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    public Optional<String> getMarque() {
        return marque;
    }

    public void setMarque(Optional<String> marque) {
        this.marque = marque;
    }

    public Optional<CarburantType> getCarburantType() {
        return carburantType;
    }

    public void setCarburantType(Optional<CarburantType> carburantType) {
        this.carburantType = carburantType;
    }
    
    public Optional<Owner> getOwner(){
    	return owner;
    }
    
    public void setOwner(Optional<Owner> owner) {
        this.owner = owner;
    }
    
    

    @Override
    public String toString() {
        return "MoyendeTransportUpdatedDTO{" +
                "numeroDeSerie=" + numeroDeSerie.orElse("Not provided") +
                ", marque=" + marque.orElse("Not provided") +
                ", carburantType=" + carburantType.orElse(null) +
                '}';
    }
}
