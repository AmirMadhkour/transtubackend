package com.transtu.spring.datajpa.dtos;

import java.util.Optional;

import com.transtu.spring.datajpa.model.District;

public class UserGeneralUpdatedDTO {

    private Optional<String> login = Optional.empty(); 
    private Optional<String> full_name = Optional.empty();
    private Optional<String> mail = Optional.empty(); 
    private Optional<String> role = Optional.empty(); 
    private Optional<String> password = Optional.empty(); 
    private Optional<Integer> tel = Optional.empty(); 
    private Optional<String> label = Optional.empty(); 
    private Optional<District> district =  Optional.empty();

    public UserGeneralUpdatedDTO() {
    }

    public UserGeneralUpdatedDTO(Optional<String> login, Optional<String> full_name , Optional<String> mail, Optional<String> role, Optional<String> password,
                                 Optional<Integer> tel, Optional<String> label , Optional<District> district ) {
        this.login = login;
        this.full_name= full_name;
        this.mail = mail;
        this.role = role;
        this.password = password;
        this.tel = tel;
        this.label = label;this.district = district ; 
    }

    // Getters and Setters
    public Optional<District>  getDistrict() {
    	return district;
    }
    
    public void setDistrict(Optional<District>  district ) {
    	this.district = district;
    }
    public Optional<String> getLogin() {
        return login;
    }

    public void setLogin(Optional<String> login) {
        this.login = login;
    }
    
    public Optional<String> getFullName() {
    	return this.full_name;
    }
    
    public void setFullName(Optional<String> full_name) {
    	this.full_name= full_name;
    }

    public Optional<String> getMail() {
        return mail;
    }

    public void setMail(Optional<String> mail) {
        this.mail = mail;
    }

    public Optional<String> getRole() {
        return role;
    }

    public void setRole(Optional<String> role) {
        this.role = role;
    }

    public Optional<String> getPassword() {
        return password;
    }

    public void setPassword(Optional<String> password) {
        this.password = password;
    }

    public Optional<Integer> getTel() {
        return tel;
    }

    public void setTel(Optional<Integer> tel) {
        this.tel = tel;
    }

    public Optional<String> getLabel() {
        return label;
    }

    public void setLabel(Optional<String> label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "UserGeneralUpdatedDTO{" +
                "login=" + login.orElse("Not provided") +
                ", mail=" + mail.orElse("Not provided") +
                ", role=" + role.orElse("Not provided") +
                ", password=" + password.orElse("Not provided") +
                ", tel=" + tel.map(String::valueOf).orElse("Not provided") +
                ", label=" + label.orElse("Not provided") +
                '}';
    }
}
