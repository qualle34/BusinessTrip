package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Allowance;

import java.util.List;

public interface AllowanceDao {

    List<Allowance> getAll();

    List<Allowance> getAllByMember(long memberId);

    Allowance getById(long id);

    void add(Allowance allowance);

    void update(Allowance allowance);

    void delete(long id);
}
