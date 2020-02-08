package com.qualle.store.repository;

import com.qualle.store.model.entity.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
}
