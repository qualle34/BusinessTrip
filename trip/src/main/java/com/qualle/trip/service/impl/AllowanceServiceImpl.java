package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.model.entity.AllowanceDictionary;
import com.qualle.trip.repository.AllowanceDao;
import com.qualle.trip.repository.AllowanceDictionaryDao;
import com.qualle.trip.service.AllowanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AllowanceServiceImpl implements AllowanceService {

    @Autowired
    private AllowanceDao allowanceDao;

    @Autowired
    private AllowanceDictionaryDao allowanceDictionaryDao;

    @Override
    public List<AllowanceDictionary> getAll() {
        return allowanceDictionaryDao.getAll();
    }

    @Override
    public List<AllowanceDto> getAllDto() {
        return toDtoArray(getAll());
    }

    @Override
    public List<MemberAllowanceDto> getAllAllowanceDtoByMember(long memberId) {
        return toMemberDtoArray(allowanceDao.getAllByMember(memberId));
    }

    @Override
    public AllowanceDictionary getById(long id) {
        return allowanceDictionaryDao.getById(id);
    }

    @Override
    public AllowanceDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public void add(Allowance allowance) {
        allowanceDao.add(allowance);
    }

    @Override
    public void add(AllowanceDictionary allowance) {
        allowanceDictionaryDao.add(allowance);
    }

    @Override
    public void update(Allowance allowance) {
        allowanceDao.update(allowance);
    }

    @Override
    public void update(AllowanceDictionary allowance) {
        allowanceDictionaryDao.update(allowance);
    }

    @Override
    public void delete(long id) {
        allowanceDictionaryDao.delete(id);
    }

    @Override
    public AllowanceDto toDto(AllowanceDictionary allowance) {
        AllowanceDto dto = new AllowanceDto(allowance.getCountry(), allowance.getValue());
        dto.setId(allowance.getId());
        return dto;
    }

    @Override
    public MemberAllowanceDto toMemberDto(Allowance allowance) {
        MemberAllowanceDto dto = new MemberAllowanceDto(allowance.getDictionary().getCountry(), allowance.getDictionary().getValue(), allowance.getDays());
        dto.setId(0);
        return dto;
    }

    @Override
    public List<AllowanceDto> toDtoArray(List<AllowanceDictionary> allowances) {
        List<AllowanceDto> dto = new ArrayList<>();
        for (AllowanceDictionary allowance : allowances) {
            dto.add(toDto(allowance));
        }
        return dto;
    }

    @Override
    public List<MemberAllowanceDto> toMemberDtoArray(List<Allowance> allowances) {
        List<MemberAllowanceDto> dto = new ArrayList<>();
        for (Allowance allowance : allowances) {
            dto.add(toMemberDto(allowance));
        }
        return dto;
    }
}
