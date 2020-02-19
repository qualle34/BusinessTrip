package com.qualle.trip.service;

import com.qualle.trip.model.dto.AllowanceSimpleDto;
import com.qualle.trip.model.entity.AllowanceDictionary;

import java.util.List;

public interface AllowanceDictionaryService {

    List<AllowanceSimpleDto> getAllDto();

    AllowanceDictionary getById(long id);

    AllowanceSimpleDto getDtoById(long id);

    AllowanceSimpleDto toDto();

    List<AllowanceSimpleDto> toDtoArray();
}
