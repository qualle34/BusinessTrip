package com.qualle.trip.service;

import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.entity.Ticket;

import java.util.Collection;
import java.util.List;

public interface TicketService {

    List<Ticket> getAll();

    List<TicketDto> getAllDto();

    List<TicketDto> getAllDtoByMember(long memberId);

    Ticket getById(long id);

    TicketDto getDtoById(long id);

    List<TicketDto> getDtoByLocation(String location);

    void add(TicketDto dto);

    void update(TicketDto dto);

    void delete(long id);

    TicketDto toDto(Ticket ticket);

    List<TicketDto> toDtoArray(Collection<Ticket> tickets);
}
