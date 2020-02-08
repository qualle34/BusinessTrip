package com.qualle.store.repository;

import com.qualle.store.model.entity.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
