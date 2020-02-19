package com.qualle.trip.repository;

import com.qualle.trip.model.entity.AllowanceDictionary;

import java.util.List;

public interface AllowanceDictionaryDao {

    List<AllowanceDictionary> getAll();

    AllowanceDictionary getById(long id);
}
