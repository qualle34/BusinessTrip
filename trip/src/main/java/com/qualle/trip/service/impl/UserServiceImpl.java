package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.UserDto;
import com.qualle.trip.model.entity.User;
import com.qualle.trip.repository.UserDao;
import com.qualle.trip.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getById(long id) {
        return userDao.getById(id);
    }

    @Override
    public UserDto getDtoById(long id) {
        return toDto(getById(id));
    }

    @Override
    public UserDto getDtoByLogin(String login) {
        return toDto(userDao.getByLogin(login));
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public UserDto toDto(User user) {
        UserDto dto = new UserDto(user.getName(), user.getEmail(), user.getLogin(), user.getPassword());
        dto.setId(user.getId());
        return dto;
    }

    @Override
    public List<UserDto> toDtoArray(List<User> users) {
        List<UserDto> dto = new ArrayList<>();
        for (User user : users) {
            dto.add(toDto(user));
        }
        return dto;
    }
}
