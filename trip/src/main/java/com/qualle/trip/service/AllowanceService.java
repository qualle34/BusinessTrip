package com.qualle.trip.service;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.model.entity.Allowance;

import java.util.List;

public interface AllowanceService {

    List<Allowance> getAll();

    List<AllowanceDto> getAllDto();

    List<MemberAllowanceDto> getAllAllowanceDtoByMember(long memberId);

    Allowance getById(long id);

    AllowanceDto getDtoById(long id);

    void add(MemberAllowance memberAllowance);

    void add(Allowance allowance);

    void update(MemberAllowance memberAllowance);

    void update(Allowance allowance);

    void delete(long id);

    AllowanceDto toDto(Allowance allowance);

    MemberAllowanceDto toMemberDto(MemberAllowance memberAllowance);

    List<AllowanceDto> toDtoArray(List<Allowance> allowances);

    List<MemberAllowanceDto> toMemberDtoArray(List<MemberAllowance> memberAllowances);
}
