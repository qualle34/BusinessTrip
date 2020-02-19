package com.qualle.trip.service;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<EmployeeDto> getAllDto();

    List<EmployeeDto> getAllDtoSortByTrip();

    List<String> getNames();

    Employee getById(long id);

    EmployeeDto getDtoById(long id);

    void add(Employee employee);

    void update(Employee employee);

    void delete(long id);

    EmployeeDto toDto(Employee employee);

    EmployeeSimpleDto toSimpleDto(Employee employee);

    List<EmployeeDto> toDtoArray(List<Employee> employees);

    List<EmployeeSimpleDto> toSimpleDtoArray(List<Employee> employees);

    Employee fromDto(EmployeeDto dto);
}
