package com.qualle.trip.service;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.entity.Allowance;

import java.util.List;

public interface AllowanceService {

    List<AllowanceDto> getAllDto();

    Allowance getById(long id);

    AllowanceDto getDtoById(long id);

    void add(Allowance allowance);

    void update(Allowance allowance);

    void delete(long id);

    AllowanceDto toDto();

    List<AllowanceDto> toDtoArray();
}
