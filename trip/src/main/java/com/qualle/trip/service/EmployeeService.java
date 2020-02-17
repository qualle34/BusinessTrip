package com.qualle.trip.service;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getDto();

    List<EmployeeDto> getDtoSortByTrip();

    Employee get(long id);

    EmployeeDto getDto(long id);
}
