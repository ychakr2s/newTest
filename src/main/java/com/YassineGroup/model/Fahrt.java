package com.YassineGroup.model;

import javax.persistence.*;

@Entity
@Table(name = "fahrt")
public class Fahrt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    String fromm;
    String too;
    String datee;
    double pricee;
    String placee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    private User oneUser;

    public Fahrt() {
    }

    public Fahrt(String from, String to, String datee, double price, String placee, User oneUser) {
        this.fromm = from;
        this.too = to;
        this.datee = datee;
        this.pricee = price;
        this.placee = placee;
        this.oneUser = oneUser;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFromm() {
        return fromm;
    }

    public void setFromm(String from) {
        this.fromm = from;
    }

    public String getToo() {
        return too;
    }

    public void setToo(String to) {
        this.too = to;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String date) {
        this.datee = date;
    }

    public double getPricee() {
        return pricee;
    }

    public void setPricee(double price) {
        this.pricee = price;
    }

    public String getPlacee() {
        return placee;
    }

    public void setPlacee(String place) {
        this.placee = place;
    }

    public User getOneUser() {
        return oneUser;
    }

    public void setOneUser(User user) {
        this.oneUser = user;
    }

    public String toString() {
        return getOneUser().getUsername() + " und " + getOneUser().getEmail();
    }

}