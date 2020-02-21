package com.qualle.trip.model.dto;

import java.util.Date;

public class TicketDto {

    private long id;
    private String from;
    private String to;
    private Date date;
    private double price;

    public TicketDto() {
    }

    public TicketDto(String from, String to, Date date, double price) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return from + " - " + to + ", " + date.toString();
    }
}
