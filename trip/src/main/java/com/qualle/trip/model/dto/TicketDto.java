package com.qualle.trip.model.dto;

import com.qualle.trip.model.enums.TicketType;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class TicketDto {

    private long id;
    private String from;
    private String to;
    private Date date;
    private double price;
    private TicketType type;
    private MemberSimpleDto member;
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

    public MemberSimpleDto getMember() {
        return member;
    }

    public void setMember(MemberSimpleDto member) {
        this.member = member;
    }

    public EmployeeSimpleDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeSimpleDto employee) {
        this.employee = employee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketDto ticketDto = (TicketDto) o;
        return id == ticketDto.id &&
                Double.compare(ticketDto.price, price) == 0 &&
                Objects.equals(from, ticketDto.from) &&
                Objects.equals(to, ticketDto.to) &&
                Objects.equals(date, ticketDto.date) &&
                type == ticketDto.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, date, price, type);
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
