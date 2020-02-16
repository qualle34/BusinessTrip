package com.qualle.trip.model.dto;

public class AllowanceDto {

    private long id;
    private double value;
    private String country;
    private int days;

    public AllowanceDto() {
    }

    public AllowanceDto(long id, double value, String country, int days) {
        this.id = id;
        this.value = value;
        this.country = country;
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
}
