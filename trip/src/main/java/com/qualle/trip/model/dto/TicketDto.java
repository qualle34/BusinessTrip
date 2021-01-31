package com.qualle.trip.model.dto;

import com.qualle.trip.model.enums.TicketType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class TicketDto {

    private long id;
    private String from;
    private String to;
    private Date date;
    private double price;
    private TicketType type;
    private MemberSimpleDto member;
    private EmployeeSimpleDto employee;

    public TicketDto(String from, String to, Date date, double price, TicketType type) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.price = price;
        this.type = type;
    }

    @Override
    public String toString() {

        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm");
            String simpleDate = formatter.format(date);
            return simpleDate + ", " + from + " - " + to;
        }

        return from + " - " + to;
    }
}
