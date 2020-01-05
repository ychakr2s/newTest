package com.YassineGroup.model;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "fahrt")
public class Fahrt implements Comparable<Fahrt> {
//        implements Comparator<Fahrt> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int Id;
    private String depart;
    private String target;
    private String dates;
    private double prices;
    private String places;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userId", nullable = false)
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

    public int getId() {
        return Id;
    }

    public void setId(int id) {
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
        return getDepart() + "  " + getTarget() + " " + getDates() + " " + getPrices() + " " + getPlaces();
    }

    @Override
    public int compareTo(Fahrt o) {
        return (this.getId() - o.getId());
    }


//    @Override
//    public int compareTo(Fahrt f1, Fahrt f2) {
//
//        return 0;
//    }

//    @Override
//    public int compare(Fahrt o1, Fahrt o2) {
//        int v1 = o1.getId();
//        int v2 = o2.getId();
//        if(v1.){
//
//        }
////        if(v1.com)
////        if ((v1.compareTo(v2)) >0) return 1;
////        else return 0;
//        return 0;
//    }
}