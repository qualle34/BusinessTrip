package com.qualle.trip.repository;

import com.qualle.trip.model.entity.User;

public interface UserDao {

    User get(long id);

    User get(String login);

    User update(User user);
}
