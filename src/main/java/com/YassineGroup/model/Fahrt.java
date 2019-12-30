package com.YassineGroup.model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "fahrt")
public class Fahrt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long Id;
    private String depart;
    private String target;
    private String dates;
    private double prices;
    private String places;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId")
    @Valid
    private User user;

    public Fahrt() {
    }

    public Fahrt(String depart, String target, String dates, double prices, String places, User user) {
        this.depart = depart;
        this.target = target;
        this.dates = dates;
        this.prices = prices;
        this.places = places;
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String from) {
        this.depart = from;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String date) {
        this.dates = date;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String place) {
        this.places = place;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return getDepart() + "  " + getTarget() + " " + getDates() + " " + getPrices();
    }

}