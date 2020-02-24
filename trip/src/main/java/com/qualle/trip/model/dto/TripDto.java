package com.qualle.trip.model.dto;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class TripDto {

    private long id;
    private String title;
    private String description;
    private Date start;
    private Date end;
    private String from;
    private String to;
    private double expenses;
    private String status;
    private List<EmployeeDto> members;
    private Map<String, List<TicketDto>> tickets;
    private Map<String, List<AllowanceDto>> allowances;

    public TripDto() {
    }

    public TripDto(String title, String description, Date start, Date end, double expenses) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<EmployeeDto> getMembers() {
        return members;
    }

    public void setMembers(List<EmployeeDto> members) {
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
