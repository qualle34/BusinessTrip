package com.qualle.trip.service.util;

import com.qualle.trip.model.dto.*;
import com.qualle.trip.model.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {

    public static AllowanceDto toAllowanceDto(Allowance allowance) {
        return new AllowanceDto();
    }

    public static EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto(employee.getName(), employee.getSurname(), employee.getEmail(), employee.getDepartment(), employee.getBirthday().toString());
        dto.setId(employee.getId());
        return dto;
    }

    public static TicketDto toTicketDto(Ticket ticket) {
        return new TicketDto();
    }

    public static TripDto toTripDto(Trip trip) {
        return new TripDto();
    }

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto(user.getName(), user.getEmail(), user.getLogin(), user.getPassword());
        dto.setId(user.getId());
        return dto;
    }

    public static List<AllowanceDto> toAllowanceDtoArray(List<Allowance> allowances) {
        List<AllowanceDto> dto = new ArrayList<>();
        for (Allowance allowance : allowances) {
            dto.add(toAllowanceDto(allowance));
        }
        return dto;
    }

    public static List<EmployeeDto> toEmployeeDtoArray(List<Employee> employees) {
        List<EmployeeDto> dto = new ArrayList<>();
        for (Employee employee : employees) {
            dto.add(toEmployeeDto(employee));
        }
        return dto;
    }

    public static List<TicketDto> toTicketDtoArray(List<Ticket> tickets) {
        List<TicketDto> dto = new ArrayList<>();
        for (Ticket ticket : tickets) {
            dto.add(toTicketDto(ticket));
        }
        return dto;
    }

    public static List<TripDto> toTripDtoArray(List<Trip> trips) {
        List<TripDto> dto = new ArrayList<>();
        for (Trip trip : trips) {
            dto.add(toTripDto(trip));
        }
        return dto;
    }

    public static List<UserDto> toUserDtoArray(List<User> users) {
        List<UserDto> dto = new ArrayList<>();
        for (User user : users) {
            dto.add(toUserDto(user));
        }
        return dto;
    }
}
