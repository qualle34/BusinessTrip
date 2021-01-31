package com.qualle.trip.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TripDto {

    private long id;
    private String title;
    private String description;
    private String place;
    private Date start;
    private Date end;
    private double ticketExpenses;
    private double allowanceExpenses;
    private double additionalExpenses;
    private double expenses;
    private String status;
    private List<MemberDto> members;

    public TripDto(long id) {
        this.id = id;
    }

    public TripDto(String title, String description, String place, Date start, Date end, double additionalExpenses) {
        this.title = title;
        this.description = description;
        this.place = place;
        this.start = start;
        this.end = end;
        this.additionalExpenses = additionalExpenses;
    }
}
