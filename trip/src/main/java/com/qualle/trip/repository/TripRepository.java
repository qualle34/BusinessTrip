package com.qualle.trip.repository;

import com.qualle.trip.model.entity.Trip;
import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {
}
