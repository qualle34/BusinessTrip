package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.model.entity.Trip;
import com.qualle.trip.model.enums.TripStatus;
import com.qualle.trip.repository.TripDao;
import com.qualle.trip.service.*;
import com.qualle.trip.service.util.ExpensesCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDao tripDao;

    @Autowired
    private MemberService memberService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AllowanceService allowanceService;

    @Autowired
    private TicketService ticketService;

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
        TripDto dto = toDto(trip);

        dto.setStatus(getStatus(trip.getStart(), trip.getEnd()));
        dto.setTicketExpenses(ExpensesCalculator.calcTicketExpenses(trip.getMembers()));
        dto.setAllowanceExpenses(ExpensesCalculator.calcAllowanceExpenses(trip.getMembers()));
        dto.setExpenses(dto.getTicketExpenses() + dto.getAllowanceExpenses() + trip.getAdditionalExpenses());

        dto.setMembers(trip.getMembers().stream().map(m -> memberService.getDtoById(m.getId())).collect(Collectors.toList()));

        return dto;
    }

    @Override
    @Transactional
    public void add(TripDto dto) {
        Trip trip = new Trip(dto.getTitle(), dto.getDescription(), dto.getPlace(), dto.getAdditionalExpenses());
        trip.setStart(dto.getStart());
        trip.setEnd(dto.getEnd());
        trip.setMembers(new HashSet<>());

        for (MemberDto memberDto : dto.getMembers()) {
            Member member = new Member();
            member.setTrip(trip);
            member.setRole(memberDto.getRole());
            member.setEmployee(employeeService.getById(memberDto.getEmployee().getId()));
            member.setTickets(memberDto.getTickets().stream().map(t -> ticketService.getById(t.getId())).collect(Collectors.toSet()));
            member.getTickets().forEach(t -> t.setMember(member));
            member.setMemberAllowances(memberDto.getAllowances().stream().map(a -> new MemberAllowance(allowanceService.getById(a.getAllowance().getId()), member, a.getDays())).collect(Collectors.toSet()));
            trip.getMembers().add(member);
        }
        tripDao.add(trip);
    }

    @Override
    @Transactional
    public void update(TripDto dto) {
        Trip trip = tripDao.getById(dto.getId());
        trip.setTitle(dto.getTitle());
        trip.setDescription(dto.getDescription());
        trip.setPlace(dto.getPlace());
        trip.setAdditionalExpenses(dto.getAdditionalExpenses());
        tripDao.update(trip);
    }

    @Override
    @Transactional
    public void delete(long id) {
        tripDao.delete(id);
    }

    @Override
    public TripDto toDto(Trip trip) {
        TripDto dto = new TripDto(trip.getTitle(), trip.getDescription(), trip.getPlace(), trip.getStart(), trip.getEnd(), trip.getAdditionalExpenses());
        dto.setId(trip.getId());
        return dto;
    }

    @Override
    public TripSimpleDto toSimpleDto(Trip trip) {
        TripSimpleDto dto = new TripSimpleDto(trip.getTitle(), trip.getDescription(), trip.getAdditionalExpenses(), getStatus(trip.getStart(), trip.getEnd()));
        dto.setId(trip.getId());
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

    private static TripStatus getStatus(Date start, Date end) {
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
