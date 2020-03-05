package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Allowance;
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
        Query query = entityManager.createQuery("SELECT a FROM Allowance a ORDER BY a.country ", Allowance.class);
        return query.getResultList();
    }

    @Override
    public List<Allowance> getByCountry(String country) {
        Query query = entityManager.createQuery("SELECT a FROM Allowance a WHERE lower(a.country) like lower(concat('%', :country,'%')) ORDER BY a.country ", Allowance.class);
        query.setParameter("country", country);
        return query.getResultList();
    }

    @Override
    public Allowance getById(long id) {
        return entityManager.find(Allowance.class, id);
    }

    @Override
    public void add(Allowance allowance) {
        entityManager.persist(allowance);
    }

    @Override
    public void update(Allowance allowance) {
        entityManager.merge(allowance);
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("DELETE FROM Allowance a WHERE a.id = :id ");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
