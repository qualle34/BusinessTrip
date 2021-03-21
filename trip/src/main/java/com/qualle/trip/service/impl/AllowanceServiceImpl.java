package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.repository.AllowanceDao;
import com.qualle.trip.repository.MemberAllowanceDao;
import com.qualle.trip.service.AllowanceService;
import com.qualle.trip.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AllowanceServiceImpl implements AllowanceService {

    @Autowired
    private MemberAllowanceDao memberAllowanceDao;

    @Autowired
    private AllowanceDao allowanceDao;

    @Autowired
    private MemberService memberService;

    @Override
    public List<Allowance> getAll() {
        return allowanceDao.getAll();
    }

    @Override
    public List<AllowanceDto> getAllDto() {
        return toDtoArray(getAll());
    }

    @Override
    public List<MemberAllowanceDto> getAllAllowanceDtoByMember(long memberId) {
        return toMemberDtoArray(memberAllowanceDao.getAllByMember(memberId));
    }

    @Override
    public Allowance getById(long id) {
        return allowanceDao.getById(id);
    }

    @Override
    public AllowanceDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public List<AllowanceDto> getDtoByCountry(String country) {
        return toDtoArray(allowanceDao.getByCountry(country));
    }

    @Override
    @Transactional
    public void add(MemberAllowanceDto dto) {
        Allowance allowance = allowanceDao.getById(dto.getAllowance().getId());
        Member member = memberService.getById(dto.getMember().getId());
        MemberAllowance memberAllowance = new MemberAllowance(allowance, member, dto.getDays());
        memberAllowanceDao.add(memberAllowance);
    }

    @Override
    @Transactional
    public void add(AllowanceDto dto) {
        allowanceDao.add(new Allowance(dto.getValue(), dto.getCountry()));
    }

    @Override
    @Transactional
    public void update(AllowanceDto dto) {
        Allowance allowance = getById(dto.getId());
        allowance.setCountry(dto.getCountry());
        allowance.setValue(dto.getValue());
        allowanceDao.update(allowance);
    }

    @Override
    @Transactional
    public void delete(long allowanceId, long memberId) {
        memberAllowanceDao.delete(allowanceId, memberId);
    }

    @Override
    @Transactional
    public void delete(long id) {
        allowanceDao.delete(id);
    }

    @Override
    public AllowanceDto toDto(Allowance allowance) {
        AllowanceDto dto = new AllowanceDto(allowance.getCountry(), allowance.getValue());
        dto.setId(allowance.getId());
        return dto;
    }

    @Override
    public MemberAllowanceDto toMemberDto(MemberAllowance memberAllowance) {
        return new MemberAllowanceDto(toDto(memberAllowance.getAllowance()), memberAllowance.getDays());
    }

    @Override
    public List<AllowanceDto> toDtoArray(Collection<Allowance> allowances) {
        List<AllowanceDto> dto = new ArrayList<>();
        for (Allowance allowance : allowances) {
            dto.add(toDto(allowance));
        }
        return dto;
    }

    @Override
    public List<MemberAllowanceDto> toMemberDtoArray(Collection<MemberAllowance> memberAllowances) {
        List<MemberAllowanceDto> dto = new ArrayList<>();
        for (MemberAllowance memberAllowance : memberAllowances) {
            dto.add(toMemberDto(memberAllowance));
        }
        return dto;
    }
}
