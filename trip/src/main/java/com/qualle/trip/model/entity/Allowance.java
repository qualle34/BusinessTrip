package com.qualle.trip.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "trip_allowance")
public class Allowance implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "allowance_id")
    private AllowanceDictionary dictionary;

    @Id
    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @Column(name = "count")
    private int count;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
