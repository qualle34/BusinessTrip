package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    List<Employee> getByTrip();

    List<Employee> getByTrip(long tripId);

    List<Employee> getByName(String name);

    Employee getById(long id);

    Employee getFullById(long id);

    void add(Employee employee);

    void update(Employee employee);

    void delete(long id);
}
