package com.transtu.spring.datajpa.dtos;

import java.util.Optional;

public class DistrictUpdatedDTO {
	    
    private Optional<Integer> code = Optional.empty();
    private Optional<String> lib = Optional.empty();

    // Default constructor
    public DistrictUpdatedDTO() {
    }

    // Parameterized constructor
    public DistrictUpdatedDTO(Optional<Integer> code, Optional<String> lib) {
        this.code = code;
        this.lib = lib;
    }

    // Getters
    public Optional<Integer> getCode() {
        return code;
    }

    public Optional<String> getLib() {
        return lib;
    }

    // Setters
    public void setCode(Optional<Integer> code) {
        this.code = code;
    }

    public void setLib(Optional<String> lib) {
        this.lib = lib;
    }
}
