package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.repository.AllowanceDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AllowanceDaoImpl implements AllowanceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Allowance> getAll() {
        return null;
    }

    @Override
    public Allowance getById(long id) {
        return null;
    }

    @Override
    public void add(Allowance allowance) {

    }

    @Override
    public void update(Allowance allowance) {

    }

    @Override
    public void delete(long id) {

    }
}
