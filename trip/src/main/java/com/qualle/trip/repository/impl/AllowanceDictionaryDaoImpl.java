package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.AllowanceDictionary;
import com.qualle.trip.repository.AllowanceDictionaryDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class AllowanceDictionaryDaoImpl implements AllowanceDictionaryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<AllowanceDictionary> getAll() {
        return null;
    }

    @Override
    public AllowanceDictionary getById(long id) {
        return null;
    }
}
