package com.qualle.trip.controller;

import com.qualle.trip.service.UserService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class UserController {

    @Autowired
    private UserService userService;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
    }
}
