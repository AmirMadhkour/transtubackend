package com.transtu.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "matricule")
    private String matricule;

    @Column(name = "telephone")
    private int telephone;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_director", referencedColumnName = "id")
    private Director director;

    // Constructors, getters, and setters
    public Owner() {
    }

    public Owner(String fullName, String matricule, int telephone, String email, Director director) {
        this.fullName = fullName;
        this.matricule = matricule;
        this.telephone = telephone;
        this.email = email;
        this.director = director;
    }

    // Getters and setters (omitted for brevity, generate using IDE or manually)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
}
