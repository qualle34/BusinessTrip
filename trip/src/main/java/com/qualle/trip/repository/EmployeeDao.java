package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    List<Employee> getAll();

    Employee get();
}
