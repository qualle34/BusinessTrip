package com.qualle.trip.model.dto;

import java.util.Objects;

public class AllowanceDto {

    private long id;
    private String country;
    private double value;
    private String currency;

    public AllowanceDto() {
    }

    public AllowanceDto(String country, double value, String currency) {
        this.country = country;
        this.value = value;
        this.currency = currency;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllowanceDto that = (AllowanceDto) o;
        return id == that.id &&
                Double.compare(that.value, value) == 0 &&
                Objects.equals(country, that.country) &&
                Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, value, currency);
    }

    @Override
    public String toString() {
        return country;
    }
}
