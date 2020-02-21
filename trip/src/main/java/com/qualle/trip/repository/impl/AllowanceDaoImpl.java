package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.model.entity.AllowanceDictionary;
import com.qualle.trip.repository.AllowanceDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AllowanceDaoImpl implements AllowanceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Allowance> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM AllowanceDictionary a", AllowanceDictionary.class);
        return query.getResultList();
    }

    @Override
    public List<Allowance> getAllByMember(long memberId) {
        Query query = entityManager.createQuery("SELECT a FROM AllowanceDictionary a", AllowanceDictionary.class);
        return query.getResultList();
    }

    @Override
    public Allowance getById(long id) {
        return entityManager.find(Allowance.class, id);
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
