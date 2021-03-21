package com.qualle.trip.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class AllowanceDto {

    private long id;
    private String country;
    private double value;

    public AllowanceDto(String country, double value) {
        this.country = country;
        this.value = value;
    }

    @Override
    public String toString() {
        return country;
    }
}
