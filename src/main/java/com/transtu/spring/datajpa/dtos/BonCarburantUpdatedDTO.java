package com.transtu.spring.datajpa.dtos;

import java.time.LocalDate;
import java.util.Optional;

import com.transtu.spring.datajpa.model.CarburantType;
import com.transtu.spring.datajpa.model.District;

public class BonCarburantUpdatedDTO {
    
    private Optional<Long> numBon = Optional.empty();
    private Optional<LocalDate> dateValable = Optional.empty();   
    private Optional<String> quantity = Optional.empty();
    private Optional<String> value = Optional.empty();
    private Optional<CarburantType> carburantType = Optional.empty();
    private Optional<District> district =  Optional.empty();

    // Default constructor
    public BonCarburantUpdatedDTO() {
    }

    // Parameterized constructor
    public BonCarburantUpdatedDTO(Optional<Long> numBon, Optional<LocalDate> dateValable, Optional<String> quantity, Optional<String> value, Optional<CarburantType> carburantType , Optional<District> district) {
        this.numBon = numBon;
        this.dateValable = dateValable;
        this.quantity = quantity;
        this.value = value;
        this.carburantType = carburantType;
        this.district = district ; 
    }

    // Getters and Setters
    public Optional<District>  getDistrict() {
    	return district;
    }
    
    public void setDistrict(Optional<District>  district ) {
    	this.district = district;
    }
    
    public Optional<Long> getNumBon() {
        return numBon;
    }

    public void setNumBon(Optional<Long> numBon) {
        this.numBon = numBon;
    }

    public Optional<LocalDate> getDateValable() {
        return dateValable;
    }

    public void setDateValable(Optional<LocalDate> dateValable) {
        this.dateValable = dateValable;
    }

    public Optional<String> getQuantity() {
        return quantity;
    }

    public void setQuantity(Optional<String> quantity) {
        this.quantity = quantity;
    }

    public Optional<String> getValue() {
        return value;
    }

    public void setValue(Optional<String> value) {
        this.value = value;
    }

    public Optional<CarburantType> getCarburantType() {
        return carburantType;
    }

    public void setCarburantType(Optional<CarburantType> carburantType) {
        this.carburantType = carburantType;
    }

    @Override
    public String toString() {
        return "BonCarburantUpdatedDTO{" +
                "numBon=" + numBon.orElse(null) +
                "dateValable=" + dateValable.orElse(null) +
                ", quantity=" + quantity.orElse("Not provided") +
                ", value=" + value.orElse("Not provided") +
                ", carburantType=" + carburantType.orElse(null) +
                '}';
    }
}
