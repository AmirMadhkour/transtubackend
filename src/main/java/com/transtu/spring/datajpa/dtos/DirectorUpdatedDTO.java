package com.transtu.spring.datajpa.dtos;

import java.util.Optional;

public class DirectorUpdatedDTO {

    private Optional<String> label;
    private Optional<Integer> telephone;
    private Optional<String> email;
    private Optional<String> address;

    // Default constructor
    public DirectorUpdatedDTO() {
        this.label = Optional.empty();
        this.telephone = Optional.empty();
        this.email = Optional.empty();
        this.address = Optional.empty();
    }

    // Parameterized constructor
    public DirectorUpdatedDTO(Optional<String> label, Optional<Integer> telephone, Optional<String> email, Optional<String> address) {
        this.label = label;
        this.telephone = telephone;
        this.email = email;
        this.address = address;
    }

    // Getters and setters
    public Optional<String> getLabel() {
        return label;
    }

    public void setLabel(Optional<String> label) {
        this.label = label;
    }

    

    public Optional<Integer> getTelephone() {
        return telephone;
    }

    public void setTelephone(Optional<Integer> telephone) {
        this.telephone = telephone;
    }

   

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

   
    public Optional<String> getAddress() {
        return address;
    }

    public void setAddress(Optional<String> address) {
        this.address = address;
    }

  
}
