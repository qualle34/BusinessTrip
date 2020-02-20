package com.qualle.trip.controller;

import com.qualle.trip.service.enums.ListType;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

public class EditController {

    private ListType type;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
    }

    public void setType(ListType type) {
        this.type = type;
    }
}
