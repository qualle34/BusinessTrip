package com.qualle.trip.model.dto;

import java.util.List;

public class MemberDto {

    private long id;
    private EmployeeDto employee;
    private TripDto tripDto;
    private List<MemberAllowanceDto> allowances;
    private List<TicketDto> tickets;

    public MemberDto() {
    }

    public MemberDto(long id, EmployeeDto employee, TripDto tripDto, List<MemberAllowanceDto> allowances, List<TicketDto> tickets) {
        this.id = id;
        this.employee = employee;
        this.tripDto = tripDto;
        this.allowances = allowances;
        this.tickets = tickets;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EmployeeDto getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDto employee) {
        this.employee = employee;
    }

    public TripDto getTripDto() {
        return tripDto;
    }

    public void setTripDto(TripDto tripDto) {
        this.tripDto = tripDto;
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
}
