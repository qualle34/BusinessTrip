package com.qualle.trip.controller.edit;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javax.annotation.PostConstruct;

public class EditAllowanceController {

    private long allowanceId;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
    }

    public void doApprove(ActionEvent event) {
    }

    public void setAllowanceId(long allowanceId) {
        this.allowanceId = allowanceId;
    }
}
