package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.repository.EmployeeDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAll() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> getAllSortByTrip() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e INNER JOIN e.members", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee getById(long id) {
        return entityManager.find(Employee.class, id);
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
}
