package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Ticket;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long> {
}
