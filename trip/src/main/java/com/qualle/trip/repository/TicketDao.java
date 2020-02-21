package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Ticket;

import java.util.List;

public interface TicketDao {

    List<Ticket> getAll();

    List<Ticket> getAllByMember(long memberId);

    Ticket getById(long id);

    void add(Ticket ticket);

    void update(Ticket ticket);

    void delete(long id);
}
