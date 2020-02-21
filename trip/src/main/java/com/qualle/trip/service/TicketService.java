package com.qualle.trip.service;

import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAll();

    List<TicketDto> getAllDto();

    List<TicketDto> getAllDtoByMember(long memberId);

    Ticket getById(long id);

    TicketDto getDtoById(long id);

    void add(Ticket ticket);

    void update(Ticket ticket);

    void delete(long id);

    TicketDto toDto(Ticket ticket);

    List<TicketDto> toDtoArray(List<Ticket> tickets);

    Ticket fromDto(TicketDto dto);
}
