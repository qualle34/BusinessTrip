package com.qualle.trip.model.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TripFullDto {

    private long id;
    private String title;
    private String description;
    private String place;
    private Date start;
    private Date end;
    private double additionalExpenses;
    private double expenses;
    private String status;
    private List<MemberDto> members;
    private Map<String, List<TicketDto>> tickets;
    private Map<String, List<AllowanceDto>> allowances;

    public TripFullDto() {
    }

    public TripFullDto(String title, String description, String place, Date start, Date end, double additionalExpenses) {
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

    public Map<String, List<TicketDto>> getTickets() {
        return tickets;
    }

    public void setTickets(Map<String, List<TicketDto>> tickets) {
        this.tickets = tickets;
    }

    public Map<String, List<AllowanceDto>> getAllowances() {
        return allowances;
    }

    public void setAllowances(Map<String, List<AllowanceDto>> allowances) {
        this.allowances = allowances;
    }
}
