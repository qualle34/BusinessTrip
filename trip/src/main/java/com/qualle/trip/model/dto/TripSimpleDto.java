package com.qualle.trip.model.dto;

import java.util.Objects;

public class TripSimpleDto {

    private long id;
    private String title;
    private String description;
    private double expenses;

    public TripSimpleDto() {
    }

    public TripSimpleDto(String title, String description, double expenses) {
        this.title = title;
        this.description = description;
        this.expenses = expenses;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripSimpleDto that = (TripSimpleDto) o;
        return id == that.id &&
                Double.compare(that.expenses, expenses) == 0 &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, expenses);
    }

    @Override
    public String toString() {
        return title;
    }
}

