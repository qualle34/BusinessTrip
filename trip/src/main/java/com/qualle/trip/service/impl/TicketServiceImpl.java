package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.Ticket;
import com.qualle.trip.repository.TicketDao;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TicketService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }

    @Override
    public List<TicketDto> getAllDto() {
        return toDtoArray(getAll());
    }

    @Override
    public List<TicketDto> getAllDtoByMember(long memberId) {
        return toDtoArray(ticketDao.getByMember(memberId));
    }

    @Override
    public Ticket getById(long id) {
        return ticketDao.getById(id);
    }

    @Override
    public TicketDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public List<TicketDto> getDtoByLocation(String location) {
        return toDtoArray(ticketDao.getByLocation(location));
    }

    @Override
    @Transactional
    public void add(Ticket ticket) {
        ticketDao.add(ticket);
    }

    @Override
    @Transactional
    public void update(Ticket ticket) {
        ticketDao.update(ticket);
    }

    @Override
    @Transactional
    public void delete(long id) {
        ticketDao.delete(id);
    }

    @Override
    public TicketDto toDto(Ticket ticket) {
        TicketDto dto = new TicketDto(ticket.getFrom(), ticket.getTo(), ticket.getDate(), ticket.getPrice(), ticket.getType());
        dto.setId(ticket.getId());
        dto.setEmployee(employeeService.toSimpleDto(ticket.getMember().getEmployee()));
        return dto;
    }

    @Override
    public List<TicketDto> toDtoArray(Collection<Ticket> tickets) {
        List<TicketDto> dto = new ArrayList<>();
        for (Ticket ticket : tickets) {
            dto.add(toDto(ticket));
        }
        return dto;
    }

    @Override
    public Ticket fromDto(TicketDto dto) {
        return new Ticket(dto.getFrom(), dto.getTo(), dto.getDate(), dto.getPrice());
    }
}
