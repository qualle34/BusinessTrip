package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.AllowanceDictionary;
import com.qualle.trip.repository.AllowanceDictionaryDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class AllowanceDictionaryDaoImpl implements AllowanceDictionaryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AllowanceDictionary> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM AllowanceDictionary a", AllowanceDictionary.class);
        return query.getResultList();
    }

    @Override
    public AllowanceDictionary getById(long id) {
        return entityManager.find(AllowanceDictionary.class, id);
    }

    @Override
    public void add(AllowanceDictionary allowance) {

    }

    @Override
    public void update(AllowanceDictionary allowance) {

    }

    @Override
    public void delete(long id) {

    }
}
