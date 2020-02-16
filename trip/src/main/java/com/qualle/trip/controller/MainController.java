package com.qualle.trip.controller;

import com.qualle.trip.service.EmployeeService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MainController {

    @Autowired
    private EmployeeService employeeService;

    @FXML
    public void initialize() {

    }

    @PostConstruct
    public void init() {
        System.out.println(employeeService.get());
    }
}
