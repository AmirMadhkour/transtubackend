package com.transtu.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carburant_type")
public class CarburantType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCarburantType;

    @Column(name = "label")
    private String label;

    // Constructors
    public CarburantType() {
    }

    public CarburantType(String label ) {
    	
        this.label = label;
    }

    // Predefined fuel types
    public static final CarburantType ESSENCE = new CarburantType("essence");
    public static final CarburantType GASSOIL = new CarburantType("gasoil");
    public static final CarburantType GAZ = new CarburantType("gaz");
    public static final CarburantType DIESEL = new CarburantType("diesel");
    public static final CarburantType ELECTRIC = new CarburantType("electric");
    public static final CarburantType CNG = new CarburantType("compressed natural gas");
    public static final CarburantType LNG = new CarburantType("liquefied natural gas");
    public static final CarburantType HYBRID = new CarburantType("hybrid");

    // Getters and setters
    public Long getIdCarburantType() {
        return idCarburantType;
    }

    public void setIdCarburantType(Long id) {
        this.idCarburantType = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
