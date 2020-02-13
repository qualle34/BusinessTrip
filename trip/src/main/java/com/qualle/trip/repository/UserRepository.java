package com.qualle.trip.repository;

import com.qualle.trip.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
