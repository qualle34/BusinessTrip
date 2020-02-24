package com.qualle.trip.model.dto;

public class MemberAllowanceDto {

    private String country;
    private double value;
    private String currency;
    private int days;

    public MemberAllowanceDto() {
    }

    public MemberAllowanceDto(String country, double value, String currency, int days) {
        this.country = country;
        this.value = value;
        this.currency = currency;
        this.days = days;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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
