package com.qualle.trip.model.dto;

import com.qualle.trip.model.enums.TripStatus;
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
    private TripStatus status;

    public TripSimpleDto(String title, String description, double expenses, TripStatus status) {
        this.title = title;
        this.description = description;
        this.expenses = expenses;
        this.status = status;
    }

    @Override
    public String toString() {
        return title;
    }
}

