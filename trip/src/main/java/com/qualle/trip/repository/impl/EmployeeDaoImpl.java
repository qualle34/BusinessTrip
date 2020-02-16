package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.repository.EmployeeDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        return null;
    }

    @Override
    public Employee get() {
        return entityManager.find(Employee.class, 1);
    }
}
