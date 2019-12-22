package com.YassineGroup.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String lastname;
    private String email_Adresse;
    private String password;

    public User() {
    }

    public User(long id, String name, String lastname, String email_Adresse, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email_Adresse = email_Adresse;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail_Adresse() {
        return email_Adresse;
    }

    public void setEmail_Adresse(String email_Adresse) {
        this.email_Adresse = email_Adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}

