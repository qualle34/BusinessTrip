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
    private String currency;

    public AllowanceDto(String country, double value, String currency) {
        this.country = country;
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return country;
    }
}
