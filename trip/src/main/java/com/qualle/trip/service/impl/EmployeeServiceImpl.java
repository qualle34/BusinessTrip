package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.repository.EmployeeDao;
import com.qualle.trip.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<EmployeeDto> getAllDto() {
        return toDtoArray(employeeDao.getAll());
    }

    @Override
    public List<EmployeeDto> getAllDtoSortByTrip() {
        return toDtoArray(employeeDao.getAllSortByTrip());
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Employee employee : employeeDao.getAllSortByTrip()) {
            names.add(employee.getName() + " " + employee.getSurname());
        }
        return names;
    }

    @Override
    public Employee getById(long id) {
        return employeeDao.getById(id);
    }

    @Override
    public EmployeeDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public void add(Employee employee) {

    }

    @Override
    public void update(Employee employee) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto(employee.getName(), employee.getSurname(), employee.getEmail(), employee.getDepartment(), employee.getBirthday().toString());
        dto.setId(employee.getId());
        return dto;
    }

    @Override
    public EmployeeSimpleDto toSimpleDto(Employee employee) {
        return null;
    }

    @Override
    public List<EmployeeDto> toDtoArray(List<Employee> employees) {
        List<EmployeeDto> dto = new ArrayList<>();
        for (Employee employee : employees) {
            dto.add(toDto(employee));
        }
        return dto;
    }

    @Override
    public List<EmployeeSimpleDto> toSimpleDtoArray(List<Employee> employees) {
        List<EmployeeSimpleDto> dto = new ArrayList<>();
        for (Employee employee : employees) {
            dto.add(toSimpleDto(employee));
        }
        return dto;
    }

    @Override
    public Employee fromDto(EmployeeDto dto) {
        return null;
    }
}
