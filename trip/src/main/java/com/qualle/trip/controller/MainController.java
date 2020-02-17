package com.qualle.trip.controller;

import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.UserService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.swing.text.html.ListView;

public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private ListView employees;

    @FXML()
    private ListView trips;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
    }
}
