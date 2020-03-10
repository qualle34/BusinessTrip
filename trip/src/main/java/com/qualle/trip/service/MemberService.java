package com.qualle.trip.service;

import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.MemberSimpleDto;
import com.qualle.trip.model.entity.Member;

import java.util.Collection;
import java.util.List;

public interface MemberService {

    List<MemberSimpleDto> getAllDto();

    Member getById(long id);

    MemberDto getDtoById(long id);

    void add(MemberDto dto);

    void update(MemberDto dto);

    void delete(long id);

    MemberDto toDto(Member member);

    MemberSimpleDto toSimpleDto(Member member);

    List<MemberSimpleDto> toSimpleDtoArray(Collection<Member> members);
}
