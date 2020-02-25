package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.model.dto.TripFullDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.model.entity.*;
import com.qualle.trip.model.enums.TripStatus;
import com.qualle.trip.repository.TripDao;
import com.qualle.trip.service.MemberService;
import com.qualle.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDao tripDao;

    @Autowired
    private MemberService memberService;

    @Override
    public List<Trip> getAll() {
        return tripDao.getAll();
    }

    @Override
    public List<TripSimpleDto> getAllSimpleDto() {
        return toSimpleDtoArray(getAll());
    }

    @Override
    public List<TripSimpleDto> getAllSimpleDtoByEmployee(long employeeId) {
        return toSimpleDtoArray(tripDao.getByEmployee(employeeId));
    }

    @Override
    public Trip getById(long id) {
        return tripDao.getById(id);
    }

    @Override
    public TripDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public TripSimpleDto getSimpleDtoById(long id) {
        return toSimpleDto(getById(id));
    }

    @Override
    public List<TripSimpleDto> getSimpleDtoByTitle(String title) {
        return toSimpleDtoArray(tripDao.getByTitle(title));
    }

    @Override
    public TripFullDto getFullDtoById(long id) {
        Trip trip = tripDao.getFullById(id);
        TripFullDto dto = new TripFullDto(trip.getTitle(), trip.getDescription(), trip.getPlace(), trip.getStart(), trip.getEnd(), trip.getAdditionalExpenses());
        dto.setStatus(getStatus(trip.getStart(), trip.getEnd()).toString());
        dto.setExpenses(calculateExpenses(trip.getMembers(), trip.getAdditionalExpenses()));
        dto.setMembers(memberService.toDtoArray(trip.getMembers()));
        return dto;
    }

    @Override
    public TripDto toDto(Trip trip) {
        TripDto dto = new TripDto(trip.getTitle(), trip.getDescription(), trip.getStart(), trip.getEnd(), trip.getAdditionalExpenses());
        dto.setId(trip.getId());
        return dto;
    }

    @Override
    public TripSimpleDto toSimpleDto(Trip trip) {
        TripSimpleDto dto = new TripSimpleDto(trip.getTitle(), trip.getDescription(), trip.getAdditionalExpenses());
        dto.setId(trip.getId());
        return dto;
    }

    @Override
    public List<TripDto> toDtoArray(Collection<Trip> trips) {
        List<TripDto> dto = new ArrayList<>();
        for (Trip trip : trips) {
            dto.add(toDto(trip));
        }
        return dto;
    }

    @Override
    public List<TripSimpleDto> toSimpleDtoArray(Collection<Trip> trips) {
        List<TripSimpleDto> dto = new ArrayList<>();
        for (Trip trip : trips) {
            dto.add(toSimpleDto(trip));
        }
        return dto;
    }

    private double calculateExpenses(Collection<Member> members, double additionalExpenses) {
        List<Ticket> tickets = new ArrayList<>();
        List<Allowance> allowances = new ArrayList<>();

        for (Member member : members) {
            tickets.addAll(member.getTickets());
            allowances.addAll(member.getMemberAllowances().stream().map(MemberAllowance::getAllowance).collect(Collectors.toList()));
        }

        double ticketExpenses = tickets.stream().mapToDouble(Ticket::getPrice).sum();
        double allowanceExpenses = allowances.stream().mapToDouble(Allowance::getValue).sum();
        return ticketExpenses + allowanceExpenses + additionalExpenses;
    }

    private TripStatus getStatus(Date start, Date end) {
        Date now = new Date();

        if (now.before(start) && now.before(end)) {
            return TripStatus.FUTURE;
        } else if (now.after(start) && now.before(end)) {
            return TripStatus.IN_PROGRESS;
        } else {
            return TripStatus.COMPLETED;
        }
    }
}
