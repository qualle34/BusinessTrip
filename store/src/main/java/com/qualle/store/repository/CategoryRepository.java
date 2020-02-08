package com.qualle.store.repository;

import com.qualle.store.model.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
