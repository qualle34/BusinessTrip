package com.qualle.store.repository;

import com.qualle.store.model.entity.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Integer> {
}
