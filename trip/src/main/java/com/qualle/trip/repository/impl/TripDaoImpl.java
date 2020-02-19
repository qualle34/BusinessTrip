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
        Query query = entityManager.createQuery("SELECT e FROM Trip e", Trip.class);
        return query.getResultList();
    }

    @Override
    public Trip getById(long id) {
        return entityManager.find(Trip.class, id);
    }
}
