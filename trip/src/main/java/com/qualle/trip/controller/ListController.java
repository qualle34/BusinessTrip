package com.qualle.trip.controller;

import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import com.qualle.trip.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class ListController {

    @Autowired
    private UserService userService;

    @Autowired
    private TripService tripService;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {

    }

    @FXML
    public void add(ActionEvent actionEvent) {
    }

    @FXML
    public void update(ActionEvent actionEvent) {
    }

    @FXML
    public void delete(ActionEvent actionEvent) {
    }
}
