package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Member;
import com.qualle.trip.repository.MemberDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Member> getAll() {
        return null;
    }

    @Override
    public Member getById(long id) {
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
}
