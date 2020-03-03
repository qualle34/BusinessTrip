package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Ticket;

import java.util.List;

public interface TicketDao {

    List<Ticket> getAll();

    List<Ticket> getByMember(long memberId);

    List<Ticket> getByMemberAndTrip(long memberId, long tripId);

    List<Ticket> getByLocation(String location);

    Ticket getById(long id);

    Ticket getFullById(long id);

    void add(Ticket ticket);

    void update(Ticket ticket);

    void delete(long id);
}
