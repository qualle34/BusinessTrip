package com.qualle.trip.model.dto;

public class AllowanceDto {

    private long id;
    private String country;
    private double value;

    public AllowanceDto() {
    }

    public AllowanceDto(String country, double value) {
        this.country = country;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return country;
    }
}
