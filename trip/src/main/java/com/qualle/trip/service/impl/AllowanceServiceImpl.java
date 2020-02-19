package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.entity.Allowance;
import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.repository.AllowanceDao;
import com.qualle.trip.service.AllowanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllowanceServiceImpl implements AllowanceService {

    @Autowired
    private AllowanceDao allowanceDao;

    @Override
    public List<AllowanceDto> getAllDto() {
        return null;
    }

    @Override
    public Allowance getById(long id) {
        return null;
    }

    @Override
    public AllowanceDto getDtoById(long id) {
        return null;
    }

    @Override
    public void add(Allowance allowance) {

    }

    @Override
    public void update(Allowance allowance) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public AllowanceDto toDto() {
        return null;
    }

    @Override
    public List<AllowanceDto> toDtoArray() {
        return null;
    }
}
