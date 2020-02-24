package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.repository.MemberAllowanceDao;
import com.qualle.trip.repository.AllowanceDao;
import com.qualle.trip.service.AllowanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllowanceServiceImpl implements AllowanceService {

    @Autowired
    private MemberAllowanceDao memberAllowanceDao;

    @Autowired
    private AllowanceDao allowanceDao;

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
    public void add(MemberAllowance memberAllowance) {
        memberAllowanceDao.add(memberAllowance);
    }

    @Override
    public void add(Allowance allowance) {
        allowanceDao.add(allowance);
    }

    @Override
    public void update(MemberAllowance memberAllowance) {
        memberAllowanceDao.update(memberAllowance);
    }

    @Override
    public void update(Allowance allowance) {
        allowanceDao.update(allowance);
    }

    @Override
    public void delete(long id) {
        allowanceDao.delete(id);
    }

    @Override
    public AllowanceDto toDto(Allowance allowance) {
        AllowanceDto dto = new AllowanceDto(allowance.getCountry(), allowance.getValue(), allowance.getCurrency());
        dto.setId(allowance.getId());
        return dto;
    }

    @Override
    public MemberAllowanceDto toMemberDto(MemberAllowance memberAllowance) {
        return new MemberAllowanceDto(memberAllowance.getAllowance().getCountry(), memberAllowance.getAllowance().getValue(),  memberAllowance.getAllowance().getCurrency(), memberAllowance.getDays());
    }

    @Override
    public List<AllowanceDto> toDtoArray(List<Allowance> allowances) {
        List<AllowanceDto> dto = new ArrayList<>();
        for (Allowance allowance : allowances) {
            dto.add(toDto(allowance));
        }
        return dto;
    }

    @Override
    public List<MemberAllowanceDto> toMemberDtoArray(List<MemberAllowance> memberAllowances) {
        List<MemberAllowanceDto> dto = new ArrayList<>();
        for (MemberAllowance memberAllowance : memberAllowances) {
            dto.add(toMemberDto(memberAllowance));
        }
        return dto;
    }
}
