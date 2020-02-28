package com.qualle.trip.repository;

import com.qualle.trip.model.entity.MemberAllowance;

import java.util.List;

public interface MemberAllowanceDao {

    List<MemberAllowance> getAll();

    List<MemberAllowance> getAllByMember(long memberId);

    MemberAllowance getById(long id);

    void add(MemberAllowance memberAllowance);

    void delete(long allowanceId, long memberId);
}
