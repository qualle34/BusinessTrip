package com.qualle.trip.service;

import com.qualle.trip.model.dto.UserDto;
import com.qualle.trip.model.entity.User;

public interface UserService {

    User get(long id);

    UserDto getDto(long id);

    UserDto get(String login);

    void update(User user);
}
