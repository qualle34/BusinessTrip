package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.entity.Member;
import com.qualle.trip.repository.MemberDao;
import com.qualle.trip.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public List<MemberDto> getAllDto() {
        return null;
    }

    @Override
    public Member getById(long id) {
        return null;
    }

    @Override
    public MemberDto getDtoById(long id) {
        return null;
    }

    @Override
    public void add(Member member) {

    }

    @Override
    public void update(Member member) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public MemberDto toDto() {
        return null;
    }

    @Override
    public List<MemberDto> toDtoArray() {
        return null;
    }
}
