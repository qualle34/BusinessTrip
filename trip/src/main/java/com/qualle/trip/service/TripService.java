package com.qualle.trip.service;

import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.model.entity.Trip;

import java.util.List;

public interface TripService {

    List<TripSimpleDto> getAllSimpleDto();

    List<String> getTitles();

    Trip getById(long id);

    TripDto getDtoById(long id);

    TripDto toDto(Trip trip);

    TripSimpleDto toSimpleDto(Trip trip);

    List<TripDto> toDtoArray(List<Trip> trips);

    List<TripSimpleDto> toSimpleDtoArray(List<Trip> trips);
}
