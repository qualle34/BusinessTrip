package com.qualle.trip.repository.impl;

import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.repository.MemberAllowanceDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class MemberAllowanceDaoImpl implements MemberAllowanceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MemberAllowance> getAll() {
        Query query = entityManager.createQuery("SELECT a FROM Allowance a", Allowance.class);
        return query.getResultList();
    }

    @Override
    public List<MemberAllowance> getAllByMember(long memberId) {
        Query query = entityManager.createQuery("SELECT a FROM Allowance a", Allowance.class);
        return query.getResultList();
    }

    @Override
    public MemberAllowance getById(long id) {
        return entityManager.find(MemberAllowance.class, id);
    }

    @Override
    public void add(MemberAllowance memberAllowance) {
        entityManager.persist(memberAllowance);
    }

    @Override
    public void delete(long allowanceId, long memberId) {
        Query query = entityManager.createQuery("DELETE FROM MemberAllowance ma WHERE ma.allowance.id = :allowanceId AND ma.member.id = :memberId");
        query.setParameter("allowanceId", allowanceId);
        query.setParameter("memberId", memberId);
        query.executeUpdate();
    }
}
