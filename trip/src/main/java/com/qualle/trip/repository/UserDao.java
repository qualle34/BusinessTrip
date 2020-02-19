package com.qualle.trip.repository;

import com.qualle.trip.model.entity.User;

public interface UserDao {

    User getById(long id);

    User getByLogin(String login);

    void update(User user);
}
