package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Trip;

import java.util.List;

public interface TripDao {

    List<Trip> getAll();

    Trip getById(long id);
}
