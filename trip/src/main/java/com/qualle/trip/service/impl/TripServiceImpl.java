package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.model.entity.Trip;
import com.qualle.trip.repository.TripDao;
import com.qualle.trip.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private TripDao tripDao;

    @Override
    public List<Trip> getAll() {
        return tripDao.getAll();
    }

    @Override
    public List<TripSimpleDto> getAllSimpleDto() {
        return toSimpleDtoArray(getAll());
    }

    @Override
    public List<TripSimpleDto> getAllSimpleDtoByEmployee(long employeeId) {
        return toSimpleDtoArray(tripDao.getByEmployee(employeeId));
    }

    @Override
    public Trip getById(long id) {
        return tripDao.getById(id);
    }

    @Override
    public TripDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public TripSimpleDto getSimpleDtoById(long id) {
        return toSimpleDto(getById(id));
    }

    @Override
    public List<TripSimpleDto> getSimpleDtoByTitle(String title) {
        return toSimpleDtoArray(tripDao.getByTitle(title));
    }

    @Override
    public TripDto toDto(Trip trip) {
        TripDto dto = new TripDto(trip.getTitle(), trip.getDescription(), trip.getStart(), trip.getEnd(), trip.getAdditionalExpenses());
        dto.setId(trip.getId());
        return dto;
    }

    @Override
    public TripSimpleDto toSimpleDto(Trip trip) {
        TripSimpleDto dto = new TripSimpleDto(trip.getTitle(), trip.getDescription(), trip.getAdditionalExpenses());
        dto.setId(trip.getId());
        return dto;
    }

    @Override
    public List<TripDto> toDtoArray(List<Trip> trips) {
        List<TripDto> dto = new ArrayList<>();
        for (Trip trip : trips) {
            dto.add(toDto(trip));
        }
        return dto;
    }

    @Override
    public List<TripSimpleDto> toSimpleDtoArray(List<Trip> trips) {
        List<TripSimpleDto> dto = new ArrayList<>();
        for (Trip trip : trips) {
            dto.add(toSimpleDto(trip));
        }
        return dto;
    }
}
