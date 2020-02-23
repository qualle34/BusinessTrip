package com.qualle.trip.controller.edit;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.service.AllowanceService;
import com.qualle.trip.service.TicketService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class EditAllowanceController {

    private long id;

    @Autowired
    private AllowanceService allowanceService;

    @FXML
    private TextField country;

    @FXML
    private TextField value;

    @FXML
    private TextField currency;

    public void doApprove(ActionEvent event) {
    }

    public void onShow() {
        if (id != 0) {
            AllowanceDto dto = allowanceService.getDtoById(id);
            country.setText(dto.getCountry());
            value.setText(String.valueOf(dto.getValue()));
            currency.setText("RUB");
        }
    }

    public void setId(long id) {
        this.id = id;
    }
}
