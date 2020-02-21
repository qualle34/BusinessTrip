package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Ticket;
import com.qualle.trip.repository.TicketDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> getAll() {
        Query query = entityManager.createQuery("SELECT t FROM Ticket t");
        return query.getResultList();
    }

    @Override
    public List<Ticket> getAllByMember(long memberId) {
        Query query = entityManager.createQuery("SELECT t FROM Ticket t JOIN t.member m WHERE m.id = :memberId");
        query.setParameter("memberId", memberId);
        return query.getResultList();
    }

    @Override
    public Ticket getById(long id) {
        return entityManager.find(Ticket.class, id);
    }

    @Override
    public void add(Ticket ticket) {

    }

    @Override
    public void update(Ticket ticket) {

    }

    @Override
    public void delete(long id) {

    }
}
