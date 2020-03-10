package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Member;
import com.qualle.trip.repository.MemberDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MemberDaoImpl implements MemberDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Member> getAll() {
        Query query = entityManager.createQuery("SELECT m FROM Member m", Member.class);
        return query.getResultList();
    }

    @Override
    public Member getById(long id) {
        Query query = entityManager.createQuery("SELECT m FROM Member m " +
                "LEFT JOIN FETCH m.employee " +
                "LEFT JOIN FETCH m.memberAllowances ma " +
                "LEFT JOIN FETCH m.tickets " +
                "LEFT JOIN FETCH ma.allowance " +
                "LEFT JOIN FETCH m.trip " +
                "WHERE m.id = :id", Member.class);
        query.setParameter("id", id);
        return (Member) query.getSingleResult();
    }

    @Override
    public void add(Member member) {
        entityManager.persist(member);
    }

    @Override
    public void update(Member member) {
        entityManager.merge(member);
    }

    @Override
    public void delete(long id) {
        Query query = entityManager.createQuery("DELETE FROM Member m WHERE m.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
