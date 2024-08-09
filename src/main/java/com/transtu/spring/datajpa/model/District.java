package com.transtu.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "district")
public class District {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "code_district", nullable = false, unique = true)
    private Integer code;
    
    @Column(name = "lib_district", nullable = false)
    private String lib;

    // Default constructor
    public District() {
    }

    // Parameterized constructor
    public District(Integer code, String lib) {
        this.code = code;
        this.lib = lib;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "District{" +
                "id=" + id +
                ", code=" + code +
                ", lib='" + lib + '\'' +
                '}';
    }
}
