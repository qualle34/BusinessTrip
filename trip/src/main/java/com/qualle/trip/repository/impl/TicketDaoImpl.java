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
        Query query = entityManager.createQuery("SELECT t FROM Ticket t ORDER BY t.date DESC ", Ticket.class);
        return query.getResultList();
    }

    @Override
    public List<Ticket> getByMember(long memberId) {
        Query query = entityManager.createQuery("SELECT t FROM Ticket t JOIN t.member m WHERE m.id = :memberId ORDER BY t.date DESC ", Ticket.class);
        query.setParameter("memberId", memberId);
        return query.getResultList();
    }

    @Override
    public List<Ticket> getByMemberAndTrip(long memberId, long tripId) {
        Query query = entityManager.createQuery("SELECT t FROM Ticket t JOIN t.member m JOIN m.trip tr WHERE m.id = :memberId and tr.id = :tripId ORDER BY t.date DESC ", Ticket.class);
        query.setParameter("memberId", memberId);
        query.setParameter("tripId", tripId);
        return query.getResultList();
    }

    @Override
    public List<Ticket> getByLocation(String location) {
        Query query = entityManager.createQuery("SELECT t FROM Ticket t WHERE concat(lower(t.from), lower(t.to)) like lower(concat('%', :location,'%')) ORDER BY t.date DESC", Ticket.class);
        query.setParameter("location", location);
        return query.getResultList();
    }

    @Override
    public Ticket getById(long id) {
        return entityManager.find(Ticket.class, id);
    }

    @Override
    public Ticket getFullById(long id) {
        Query query = entityManager.createQuery("SELECT t FROM Ticket t LEFT JOIN FETCH t.member m LEFT JOIN FETCH m.employee WHERE t.id = :id ", Ticket.class);
        query.setParameter("id", id);
        return (Ticket) query.getSingleResult();
    }

    @Override
    public void add(Ticket ticket) {
        entityManager.persist(ticket);
    }

    @Override
    public void update(Ticket ticket) {
        entityManager.merge(ticket);
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("DELETE FROM Ticket t WHERE t.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
