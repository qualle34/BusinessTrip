package com.qualle.trip.model.dto;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public TripDto() {
    }

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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public double getTicketExpenses() {
        return ticketExpenses;
    }

    public void setTicketExpenses(double ticketExpenses) {
        this.ticketExpenses = ticketExpenses;
    }

    public double getAllowanceExpenses() {
        return allowanceExpenses;
    }

    public void setAllowanceExpenses(double allowanceExpenses) {
        this.allowanceExpenses = allowanceExpenses;
    }

    public double getAdditionalExpenses() {
        return additionalExpenses;
    }

    public void setAdditionalExpenses(double additionalExpenses) {
        this.additionalExpenses = additionalExpenses;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<MemberDto> getMembers() {
        return members;
    }

    public void setMembers(List<MemberDto> members) {
        this.members = members;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TripDto tripDto = (TripDto) o;
        return id == tripDto.id &&
                Double.compare(tripDto.ticketExpenses, ticketExpenses) == 0 &&
                Double.compare(tripDto.allowanceExpenses, allowanceExpenses) == 0 &&
                Double.compare(tripDto.additionalExpenses, additionalExpenses) == 0 &&
                Double.compare(tripDto.expenses, expenses) == 0 &&
                Objects.equals(title, tripDto.title) &&
                Objects.equals(description, tripDto.description) &&
                Objects.equals(place, tripDto.place) &&
                Objects.equals(start, tripDto.start) &&
                Objects.equals(end, tripDto.end) &&
                Objects.equals(status, tripDto.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, place, start, end, ticketExpenses, allowanceExpenses, additionalExpenses, expenses, status);
    }
}
