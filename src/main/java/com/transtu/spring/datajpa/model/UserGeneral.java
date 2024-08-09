package com.transtu.spring.datajpa.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserGeneral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    
    @Column(name = "FullName")
    private String full_name;
    
    @Column(name = "Login")
    private String login;

    @Column(name = "Mail")
    private String mail;

    @Column(name = "Role")
    private String role;

    @Column(name = "Password")
    private String password;

    @Column(name = "Tel")
    private int tel;

    @Column(name = "Label")
    private String label;
    
    @ManyToOne
    @JoinColumn(name = "id_district", referencedColumnName = "id")
    private District district;

    public UserGeneral() {
    }

    public UserGeneral(String login, String full_name , String mail, String role, String password, int tel, String label , District district) {
        this.login = login;
        this.full_name = full_name; 
        this.mail = mail;
        this.role = role;
        this.password = password;
        this.tel = tel;
        this.label = label;
        this.district= district ; 
    }
    
    public District getDistrict() {
    	return district;
    }
    
    public void setDistrict(District district ) {
    	this.district = district;
    }
    
    
    public String getFullName() {
    	return this.full_name;
    }
    
    public void setFullName(String full_name) {
    	this.full_name= full_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "UserGeneral [id=" + id + ", login=" + login + ", mail=" + mail + ", role=" + role + 
               ", password=" + password + ", tel=" + tel + ", label=" + label + "]";
    }
}
