package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.Ticket;
import com.qualle.trip.repository.TicketDao;
import com.qualle.trip.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Override
    public List<TicketDto> getAllDto() {
        return null;
    }

    @Override
    public List<TicketDto> getAllDtoByMember(Member member) {
        return null;
    }

    @Override
    public Ticket getById(long id) {
        return null;
    }

    @Override
    public TicketDto getDtoById(long id) {
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

    @Override
    public TicketDto toDto(Ticket ticket) {
        return null;
    }

    @Override
    public List<TicketDto> toDtoArray(List<Ticket> tickets) {
        List<TicketDto> dto = new ArrayList<>();
        for (Ticket ticket : tickets) {
            dto.add(toDto(ticket));
        }
        return dto;
    }

    @Override
    public Ticket fromDto(TicketDto dto) {
        return null;
    }
}
