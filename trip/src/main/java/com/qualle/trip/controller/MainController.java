package com.qualle.trip.controller;

import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MainController {

    @Autowired
    private TripService tripService;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private ListView<String> employeeList;

    @FXML
    private ListView<String> tripList;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
        ObservableList<String> employeesNames = FXCollections.observableArrayList(employeeService.getNames());
        employeeList.setItems(employeesNames);
        ObservableList<String> tripsTitles = FXCollections.observableArrayList(tripService.getTitles());
        tripList.setItems(tripsTitles);
    }
}
