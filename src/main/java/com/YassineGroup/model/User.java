package com.YassineGroup.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String username;

    @Column(name = "email")
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "fahrtId")
    private Set<Fahrt> fahrt;

    public User() {
    }

    public User(String name, String lastname, String username, String email_Adresse, String password) {
        super();
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.email = email_Adresse;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email_Adresse) {
        this.email = email_Adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Fahrt> getFahrt() {
        return fahrt;
    }

    public void setFahrt(Set<Fahrt> fahrt) {
        this.fahrt = fahrt;
    }

    public String toString() {
        return getFahrt().toString();
    }
}

