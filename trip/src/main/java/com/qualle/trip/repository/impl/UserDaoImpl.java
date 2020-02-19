package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.User;
import com.qualle.trip.repository.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public User getById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getByLogin(String login) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login");
        query.setParameter("login", login);
        return (User) query.getSingleResult();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }
}