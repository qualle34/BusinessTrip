package com.qualle.trip.service.util;

import com.qualle.trip.model.dto.UserDto;

import java.util.ArrayList;
import java.util.List;

public class SimpleStorage {

    public static List<UserDto> users = new ArrayList<>(10);

    public static void setUser(UserDto user) {
        users.add(user);
    }

    public static UserDto getUser() {
        if (!users.isEmpty()) {
            return users.get(0);
        }
        return null;
    }

    public static String getName() {
        if (!users.isEmpty()) {
            return users.get(0).getName();
        }
        return null;
    }
}
