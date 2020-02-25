package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.repository.EmployeeDao;
import com.qualle.trip.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public List<EmployeeDto> getAllDto() {
        return toDtoArray(getAll());
    }

    @Override
    public List<EmployeeSimpleDto> getAllSimpleDto() {
        return toSimpleDtoArray(getAll());
    }

    @Override
    public List<EmployeeSimpleDto> getAllSimpleDtoByTrip() {
        return toSimpleDtoArray(employeeDao.getByTrip());
    }

    @Override
    public List<EmployeeSimpleDto> getAllSimpleDtoByTrip(long tripId) {
        return toSimpleDtoArray(employeeDao.getByTrip(tripId));
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
    public List<EmployeeSimpleDto> getSimpleDtoByName(String name) {
        return toSimpleDtoArray(employeeDao.getByName(name));
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
        EmployeeDto dto = new EmployeeDto(employee.getName(), employee.getSurname(), employee.getEmail(), employee.getDepartment(), employee.getBirthday());
        dto.setId(employee.getId());
        return dto;
    }

    @Override
    public EmployeeSimpleDto toSimpleDto(Employee employee) {
        EmployeeSimpleDto dto = new EmployeeSimpleDto(employee.getName(), employee.getSurname(), employee.getEmail());
        dto.setId(employee.getId());
        return dto;
    }

    @Override
    public List<EmployeeDto> toDtoArray(Collection<Employee> employees) {
        List<EmployeeDto> dto = new ArrayList<>();
        for (Employee employee : employees) {
            dto.add(toDto(employee));
        }
        return dto;
    }

    @Override
    public List<EmployeeSimpleDto> toSimpleDtoArray(Collection<Employee> employees) {
        List<EmployeeSimpleDto> dto = new ArrayList<>();
        for (Employee employee : employees) {
            dto.add(toSimpleDto(employee));
        }
        return dto;
    }

    @Override
    public Employee fromDto(EmployeeDto dto) {
        return new Employee();
    }
}
