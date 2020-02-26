package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.model.entity.Ticket;
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
    public List<Employee> getByTrip() {
        Query query = entityManager.createQuery("SELECT e FROM Employee e INNER JOIN e.members", Employee.class);
        return query.getResultList();
    }

    @Override
    public List<Employee> getByTrip(long tripId) {
        Query query = entityManager.createQuery("SELECT e FROM Employee e INNER JOIN e.members m JOIN m.trip t WHERE t.id = :tripId", Employee.class);
        query.setParameter("tripId", tripId);
        return query.getResultList();
    }

    @Override
    public List<Employee> getByName(String name) {
        Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE concat(lower(e.name), lower(e.surname)) like lower(concat('%', :name,'%'))", Employee.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    @Override
    public Employee getById(long id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee getFullById(long id) {
        Query query = entityManager.createQuery("SELECT e FROM Employee e " +
                "INNER JOIN FETCH e.members m " +
                "LEFT JOIN FETCH m.tickets " +
                "LEFT JOIN FETCH m.trip " +
                "WHERE e.id = :id", Employee.class);
        query.setParameter("id", id);
        return (Employee) query.getSingleResult();
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
