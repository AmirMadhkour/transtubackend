package com.transtu.spring.datajpa.dtos;

import java.util.Optional;
import com.transtu.spring.datajpa.model.Director;

public class OwnerUpdatedDTO {
    private Optional<String> fullName = Optional.empty(); 
    private Optional<String> matricule = Optional.empty();
    private Optional<Integer> telephone = Optional.empty();  // Use Optional<Integer> instead of Optional<int>
    private Optional<String> email = Optional.empty();
    private Optional<Director> director = Optional.empty();

    // Default constructor
    public OwnerUpdatedDTO() {}

    // Parameterized constructor
    public OwnerUpdatedDTO(Optional<String> fullName, Optional<String> matricule, 
                           Optional<Integer> telephone, Optional<String> email, 
                           Optional<Director> director) {
        this.fullName = fullName;
        this.matricule = matricule;
        this.telephone = telephone;
        this.email = email;
        this.director = director;
    }

    // Getters and Setters
    public Optional<String> getFullName() {
        return fullName;
    }

    public void setFullName(Optional<String> fullName) {
        this.fullName = fullName;
    }

    public Optional<String> getMatricule() {
        return matricule;
    }

    public void setMatricule(Optional<String> matricule) {
        this.matricule = matricule;
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

    public Optional<Director> getDirector() {
        return director;
    }

    public void setDirector(Optional<Director> director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "OwnerUpdatedDTO{" +
                "fullName=" + fullName.orElse("Not provided") +
                ", matricule=" + matricule.orElse("Not provided") +
                ", telephone=" + telephone.map(String::valueOf).orElse("Not provided") +
                ", email=" + email.orElse("Not provided") +
                ", director=" + director.orElse(null) +
                '}';
    }
}
