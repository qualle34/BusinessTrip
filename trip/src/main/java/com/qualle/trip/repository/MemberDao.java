package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Member;

import java.util.List;

public interface MemberDao {

    List<Member> getAll();

    Member getById(long id);

    void add(Member member);

    void update(Member member);

    void delete(long id);
}
