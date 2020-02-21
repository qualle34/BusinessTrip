package com.qualle.trip.service;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.model.entity.AllowanceDictionary;

import java.util.List;

public interface AllowanceService {

    List<AllowanceDictionary> getAll();

    List<AllowanceDto> getAllDto();

    List<MemberAllowanceDto> getAllAllowanceDtoByMember(long memberId);

    AllowanceDictionary getById(long id);

    AllowanceDto getDtoById(long id);

    void add(Allowance allowance);

    void add(AllowanceDictionary allowance);

    void update(Allowance allowance);

    void update(AllowanceDictionary allowance);

    void delete(long id);

    AllowanceDto toDto(AllowanceDictionary allowance);

    MemberAllowanceDto toMemberDto(Allowance allowance);

    List<AllowanceDto> toDtoArray(List<AllowanceDictionary> allowances);

    List<MemberAllowanceDto> toMemberDtoArray(List<Allowance> allowances);
}
