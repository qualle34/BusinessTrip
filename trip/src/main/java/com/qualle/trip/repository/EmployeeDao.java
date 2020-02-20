package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    List<Employee> getAllByTrip();

    List<Employee> getAllByTrip(long tripId);

    Employee getById(long id);

    void add(Employee employee);

    void update(Employee employee);

    void delete(long id);
}
