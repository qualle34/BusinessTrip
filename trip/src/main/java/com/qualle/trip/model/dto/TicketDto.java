package com.qualle.trip.model.dto;

import com.qualle.trip.model.enums.TicketType;

import java.util.Date;

public class TicketDto {

    private long id;
    private String from;
    private String to;
    private Date date;
    private double price;
    private TicketType type;
    private EmployeeSimpleDto employee;

    public TicketDto() {
    }

    public TicketDto(String from, String to, Date date, double price, TicketType type) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.price = price;
        this.type = type;
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

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public EmployeeSimpleDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeSimpleDto employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return from + " - " + to + ", " + date.toString();
    }
}
