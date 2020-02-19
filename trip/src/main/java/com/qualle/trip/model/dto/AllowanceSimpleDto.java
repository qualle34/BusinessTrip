package com.qualle.trip.model.dto;

public class AllowanceSimpleDto {

    private long id;
    private double value;
    private String country;

    public AllowanceSimpleDto() {
    }

    public AllowanceSimpleDto(long id, double value, String country) {
        this.id = id;
        this.value = value;
        this.country = country;
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
}
