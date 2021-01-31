package com.qualle.trip.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class MemberDto {

    private long id;
    private double allowanceExpenses;
    private double ticketsExpenses;
    private String role;
    private EmployeeDto employee;
    private TripDto trip;
    private List<MemberAllowanceDto> allowances;
    private List<TicketDto> tickets;

    public MemberDto(double allowanceExpenses, double ticketsExpenses, EmployeeDto employee, TripDto trip, List<MemberAllowanceDto> allowances, List<TicketDto> tickets) {
        this.allowanceExpenses = allowanceExpenses;
        this.ticketsExpenses = ticketsExpenses;
        this.employee = employee;
        this.trip = trip;
        this.allowances = allowances;
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return employee.toString();
    }
}
