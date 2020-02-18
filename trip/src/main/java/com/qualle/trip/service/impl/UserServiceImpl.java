package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.UserDto;
import com.qualle.trip.model.entity.User;
import com.qualle.trip.repository.UserDao;
import com.qualle.trip.service.UserService;
import com.qualle.trip.service.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User get(long id) {
        return userDao.get(id);
    }

    @Override
    public UserDto getDto(long id) {
        return ConverterUtil.toUserDto(userDao.get(id));
    }

    @Override
    public UserDto get(String login) {
        return ConverterUtil.toUserDto(userDao.get(login));
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }
}
