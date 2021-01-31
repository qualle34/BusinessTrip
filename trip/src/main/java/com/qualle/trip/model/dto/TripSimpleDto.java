package com.qualle.trip.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TripSimpleDto {

    private long id;
    private String title;
    private String description;
    private double expenses;

    public TripSimpleDto(String title, String description, double expenses) {
        this.title = title;
        this.description = description;
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return title;
    }
}

