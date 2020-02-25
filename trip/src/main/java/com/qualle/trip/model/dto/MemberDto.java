package com.qualle.trip.model.dto;

import java.util.List;

public class MemberDto {

    private long id;
    private double allowanceExpenses;
    private double ticketsExpenses;
    private EmployeeDto employee;
    private TripDto trip;
    private List<MemberAllowanceDto> allowances;
    private List<TicketDto> tickets;

    public MemberDto() {
    }

    public MemberDto(double allowanceExpenses, double ticketsExpenses, EmployeeDto employee, TripDto trip, List<MemberAllowanceDto> allowances, List<TicketDto> tickets) {
        this.allowanceExpenses = allowanceExpenses;
        this.ticketsExpenses = ticketsExpenses;
        this.employee = employee;
        this.trip = trip;
        this.allowances = allowances;
        this.tickets = tickets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getAllowanceExpenses() {
        return allowanceExpenses;
    }

    public void setAllowanceExpenses(double allowanceExpenses) {
        this.allowanceExpenses = allowanceExpenses;
    }

    public double getTicketsExpenses() {
        return ticketsExpenses;
    }

    public void setTicketsExpenses(double ticketsExpenses) {
        this.ticketsExpenses = ticketsExpenses;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public TripDto getTrip() {
        return trip;
    }

    public void setTrip(TripDto trip) {
        this.trip = trip;
    }

    public List<MemberAllowanceDto> getAllowances() {
        return allowances;
    }

    public void setAllowances(List<MemberAllowanceDto> allowances) {
        this.allowances = allowances;
    }

    public List<TicketDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDto> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
