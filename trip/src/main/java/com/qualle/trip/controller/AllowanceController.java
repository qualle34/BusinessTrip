package com.qualle.trip.controller;

import com.qualle.trip.service.AllowanceService;
import javafx.fxml.FXML;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class AllowanceController {

    @Autowired
    private AllowanceService allowanceService;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
    }
}
