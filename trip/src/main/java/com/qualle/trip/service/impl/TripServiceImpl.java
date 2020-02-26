package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.model.entity.*;
import com.qualle.trip.model.enums.TripStatus;
import com.qualle.trip.repository.TripDao;
import com.qualle.trip.service.MemberService;
import com.qualle.trip.service.TripService;
import com.qualle.trip.service.util.WordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
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
    public TripDto getFullDtoById(long id) {
        Trip trip = tripDao.getFullById(id);
        TripDto dto = new TripDto(trip.getTitle(), trip.getDescription(), trip.getPlace(), trip.getStart(), trip.getEnd(), trip.getAdditionalExpenses());
        dto.setStatus(getStatus(trip.getStart(), trip.getEnd()).toString());
        dto.setExpenses(calculateExpenses(trip.getMembers(), trip.getAdditionalExpenses()));
        dto.setMembers(memberService.toSimpleDtoArray(trip.getMembers()));
        return dto;
    }

    @Override
    public void add(TripDto dto) {
        Trip trip = new Trip(dto.getTitle(), dto.getDescription(), dto.getPlace());
        tripDao.add(trip);
    }

    @Override
    public void update(TripDto dto) {
        Trip trip = tripDao.getById(dto.getId());
        trip.setTitle(dto.getTitle());
        tripDao.update(trip);
    }

    @Override
    public void delete(long id) {
        tripDao.delete(id);
    }

    @Override
    public void report(long id, String path) {
        Map<String, String> data = new HashMap<>();
        Trip trip = tripDao.getFullById(id);

        data.put("title", trip.getTitle());
        data.put("description", trip.getDescription());
        data.put("members", "test, test");
        data.put("expenses", String.valueOf(trip.getAdditionalExpenses()));
        data.put("date_start", trip.getEnd().toString());
        data.put("date_end", trip.getStart().toString());
        WordUtil.createReport(path, data);
    }

    @Override
    public TripDto toDto(Trip trip) {
        TripDto dto = new TripDto(trip.getTitle(), trip.getDescription(), trip.getPlace(), trip.getStart(), trip.getEnd(), trip.getAdditionalExpenses());
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
