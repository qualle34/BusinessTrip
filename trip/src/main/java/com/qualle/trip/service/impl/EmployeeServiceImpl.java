package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.model.entity.Member;
import com.qualle.trip.repository.EmployeeDao;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TicketService;
import com.qualle.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private TripService tripService;

    @Autowired
    private TicketService ticketService;

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
    public EmployeeDto getFullDtoById(long id) {
        Employee employee = employeeDao.getFullById(id);
        EmployeeDto dto = toDto(employee);
        for (Member member : employee.getMembers()) {
            if (dto.getTickets() == null && dto.getTrips() == null) {
                dto.setTickets(new ArrayList<>());
                dto.setTrips(new ArrayList<>());
            }
            dto.getTickets().addAll(ticketService.toDtoArray(member.getTickets()));
            dto.getTrips().add(tripService.toSimpleDto(member.getTrip()));
        }
        return dto;
    }

    @Override
    public List<EmployeeSimpleDto> getSimpleDtoByName(String name) {
        return toSimpleDtoArray(employeeDao.getByName(name));
    }

    @Override
    @Transactional
    public void add(EmployeeDto dto) {
        Employee employee = new Employee(dto.getName(), dto.getSurname(), dto.getPatronymic(), dto.getPosition(), dto.getDepartment(), dto.getEmail(), dto.getBirthday());
        employeeDao.add(employee);
    }

    @Override
    @Transactional
    public void update(EmployeeDto dto) {
        Employee employee = getById(dto.getId());
        employee.setName(dto.getName());
        employee.setSurname(dto.getSurname());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setBirthday(dto.getBirthday());
        employeeDao.update(employee);
    }

    @Override
    @Transactional
    public void delete(long id) {
        employeeDao.delete(id);
    }

    @Override
    public EmployeeDto toDto(Employee employee) {
        EmployeeDto dto = new EmployeeDto(employee.getName(), employee.getSurname(), employee.getPatronymic(), employee.getPosition(), employee.getDepartment(), employee.getEmail(), employee.getBirthday());
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
}
