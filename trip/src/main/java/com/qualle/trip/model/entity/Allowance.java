package com.qualle.trip.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "trip_allowance", schema = "public")
public class Allowance implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "allowance_id")
    private AllowanceDictionary dictionary;

    @Id
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "days")
    private int days;

    public Allowance() {
    }

    public AllowanceDictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(AllowanceDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return String.valueOf(days);
    }
}
