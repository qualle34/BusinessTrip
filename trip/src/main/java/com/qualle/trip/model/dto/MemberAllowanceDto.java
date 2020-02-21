package com.qualle.trip.model.dto;

public class MemberAllowanceDto {

    private long id;
    private String country;
    private double value;
    private int days;

    public MemberAllowanceDto() {
    }

    public MemberAllowanceDto(String country, double value, int days) {
        this.country = country;
        this.value = value;
        this.days = days;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return country;
    }
}
