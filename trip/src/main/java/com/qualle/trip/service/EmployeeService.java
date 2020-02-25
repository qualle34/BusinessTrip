package com.qualle.trip.service;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.entity.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    List<EmployeeDto> getAllDto();

    List<EmployeeSimpleDto> getAllSimpleDto();

    List<EmployeeSimpleDto> getAllSimpleDtoByTrip();

    List<EmployeeSimpleDto> getAllSimpleDtoByTrip(long tripId);

    Employee getById(long id);

    EmployeeDto getDtoById(long id);

    List<EmployeeSimpleDto> getSimpleDtoByName(String name);

    void add(Employee employee);

    void update(Employee employee);

    void delete(long id);

    EmployeeDto toDto(Employee employee);

    EmployeeSimpleDto toSimpleDto(Employee employee);

    List<EmployeeDto> toDtoArray(Collection<Employee> employees);

    List<EmployeeSimpleDto> toSimpleDtoArray(Collection<Employee> employees);

    Employee fromDto(EmployeeDto dto);
}
