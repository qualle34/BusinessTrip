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
    public List<Employee> get() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e");
        return query.getResultList();
    }

    @Override
    public List<Employee> getSortByTrip() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e INNER JOIN e.trip");
        return query.getResultList();
    }

    @Override
    public Employee get(long id) {
        return entityManager.find(Employee.class, id);
    }
}
