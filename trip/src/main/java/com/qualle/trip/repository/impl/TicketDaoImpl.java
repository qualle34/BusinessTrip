package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.Ticket;
import com.qualle.trip.repository.TicketDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> getAll() {
        return null;
    }

    @Override
    public List<Ticket> getAllByMember(Member member) {
        return null;
    }

    @Override
    public Ticket getById(long id) {
        return null;
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
