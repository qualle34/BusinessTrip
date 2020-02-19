package com.qualle.trip.service;

import com.qualle.trip.model.dto.UserDto;
import com.qualle.trip.model.entity.User;

import java.util.List;

public interface UserService {

    User getById(long id);

    UserDto getDtoById(long id);

    UserDto getDtoByLogin(String login);

    void update(User user);

    UserDto toDto(User user);

    List<UserDto> toDtoArray(List<User> users);
}
