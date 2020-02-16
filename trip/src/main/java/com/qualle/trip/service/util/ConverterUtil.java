package com.qualle.trip.service.util;

import com.qualle.trip.model.dto.*;
import com.qualle.trip.model.entity.*;

import java.util.ArrayList;
import java.util.List;

public class ConverterUtil {

    public static AllowanceDto toDto(Allowance allowance){
        return new AllowanceDto();
    }

    public static EmployeeDto toDto(Employee employee){
        return new EmployeeDto();
    }

    public static TicketDto toDto(Ticket ticket){
        return new TicketDto();
    }

    public static TripDto toDto(Trip trip){
        return new TripDto();
    }

    public static UserDto toDto(User user){
        return new UserDto();
    }

    public static List<AllowanceDto> toDtoArray(Allowance allowance){
        return new ArrayList<>();
    }

    public static List<EmployeeDto> toDtoArray(Employee employee){
        return new ArrayList<>();
    }

    public static List<TicketDto> toDtoArray(Ticket ticket){
        return new ArrayList<>();
    }

    public static List<TripDto> toDtoArray(Trip trip){
        return new ArrayList<>();
    }

    public static List<UserDto> toDtoArray(User user){
        return new ArrayList<>();
    }
}
