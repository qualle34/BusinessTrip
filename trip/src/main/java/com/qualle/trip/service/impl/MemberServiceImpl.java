package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.MemberSimpleDto;
import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.model.entity.Ticket;
import com.qualle.trip.repository.MemberDao;
import com.qualle.trip.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TripService tripService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private AllowanceService allowanceService;

    @Override
    public List<MemberSimpleDto> getAllDto() {
        return toSimpleDtoArray(memberDao.getAll());
    }

    @Override
    public Member getById(long id) {
        return memberDao.getById(id);
    }

    @Override
    public MemberDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    @Transactional
    public void add(MemberDto dto) {
        Member member = new Member();
        member.setEmployee(employeeService.getById(dto.getEmployee().getId()));
        member.setTrip(tripService.getById(dto.getTrip().getId()));
        member.setRole(dto.getRole());
        memberDao.add(member);
    }

    @Override
    @Transactional
    public void update(MemberDto dto) {
        Member member = memberDao.getById(dto.getId());
        member.setRole(dto.getRole());
        memberDao.update(member);
    }

    @Override
    @Transactional
    public void delete(long id) {
        memberDao.delete(id);
    }

    @Override
    public MemberDto toDto(Member member) {
        double ticketsExpenses = member.getTickets().stream().mapToDouble(Ticket::getPrice).sum();
        double allowancesExpenses = member.getMemberAllowances().stream().map(MemberAllowance::getAllowance).mapToDouble(Allowance::getValue).sum();
        MemberDto dto = new MemberDto(allowancesExpenses, ticketsExpenses, employeeService.toDto(member.getEmployee()), tripService.toDto(member.getTrip()),
                allowanceService.toMemberDtoArray(member.getMemberAllowances()), ticketService.toDtoArray(member.getTickets()));
        dto.setId(member.getId());
        return dto;
    }

    @Override
    public MemberSimpleDto toSimpleDto(Member member) {
        MemberSimpleDto dto = new MemberSimpleDto(member.getId(), member.getEmployee().getName(), member.getEmployee().getSurname(), member.getRole());
        dto.setId(member.getId());
        return dto;
    }

    @Override
    public List<MemberSimpleDto> toSimpleDtoArray(Collection<Member> members) {
        List<MemberSimpleDto> dto = new ArrayList<>();
        for (Member member : members) {
            dto.add(toSimpleDto(member));
        }
        return dto;
    }
}
