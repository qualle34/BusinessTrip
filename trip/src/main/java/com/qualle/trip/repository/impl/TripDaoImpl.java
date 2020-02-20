package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Trip;
import com.qualle.trip.repository.TripDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TripDaoImpl implements TripDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Trip> getAll() {
        Query query = entityManager.createQuery("SELECT t FROM Trip t", Trip.class);
        return query.getResultList();
    }

    @Override
    public List<Trip> getAllByEmployee(long employeeId) {
        Query query = entityManager.createQuery("SELECT t FROM Trip t INNER JOIN t.members m JOIN m.employee e WHERE e.id = :employeeId", Trip.class);
        query.setParameter("employeeId", employeeId);
        return query.getResultList();
    }

    @Override
    public Trip getById(long id) {
        return entityManager.find(Trip.class, id);
    }
}
