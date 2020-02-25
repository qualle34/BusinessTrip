package com.qualle.trip.service;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.model.entity.Allowance;

import java.util.Collection;
import java.util.List;

public interface AllowanceService {

    List<Allowance> getAll();

    List<AllowanceDto> getAllDto();

    List<MemberAllowanceDto> getAllAllowanceDtoByMember(long memberId);

    Allowance getById(long id);

    AllowanceDto getDtoById(long id);

    List<AllowanceDto> getDtoByCountry(String name);

    void add(MemberAllowance memberAllowance);

    void add(AllowanceDto dto);

    void update(MemberAllowance memberAllowance);

    void update(AllowanceDto dto);

    void delete(long id);

    AllowanceDto toDto(Allowance allowance);

    MemberAllowanceDto toMemberDto(MemberAllowance memberAllowance);

    List<AllowanceDto> toDtoArray(Collection<Allowance> allowances);

    List<MemberAllowanceDto> toMemberDtoArray(Collection<MemberAllowance> memberAllowances);
}
