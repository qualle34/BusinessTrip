package com.qualle.trip.model.dto;

import java.util.Date;

public class TripSimpleDto {

    private long id;
    private String title;
    private String description;
    private Date start;
    private Date end;
    private String from;
    private String to;
    private double expenses;

    public TripSimpleDto() {
    }

    public TripSimpleDto(String title, String description, Date start, Date end, String from, String to, double expenses) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.from = from;
        this.to = to;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
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

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }
}
