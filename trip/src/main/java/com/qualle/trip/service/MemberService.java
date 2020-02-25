package com.qualle.trip.service;

import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.entity.Member;

import java.util.Collection;
import java.util.List;

public interface MemberService {

    List<MemberDto> getAllDto();

    Member getById(long id);

    MemberDto getDtoById(long id);

    MemberDto getFullDtoById(long id);

    void add(Member member);

    void update(Member member);

    void delete(long id);

    MemberDto toDto(Member member);

    List<MemberDto> toDtoArray(Collection<Member> members);
}
