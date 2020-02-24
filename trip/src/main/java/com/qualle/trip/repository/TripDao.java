package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Trip;

import java.util.List;

public interface TripDao {

    List<Trip> getAll();

    List<Trip> getByEmployee(long employeeId);

    List<Trip> getByTitle(String title);

    Trip getById(long id);
}
