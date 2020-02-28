package com.qualle.trip.controller.edit;

import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.service.AllowanceService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

public class EditAllowanceController implements AbstractController {

    private AllowanceDto dto;
    private long id;

    @Autowired
    private AllowanceService allowanceService;

    @FXML
    private TextField country;

    @FXML
    private TextField value;

    @FXML
    private TextField currency;

    @Override
    public void onShow() {

        if (id != 0) {
            dto = allowanceService.getDtoById(id);
            country.setText(dto.getCountry());
            value.setText(String.valueOf(dto.getValue()));
            currency.setText(dto.getCurrency());

        } else {
            dto = null;
            country.setText("");
            value.setText("");
            currency.setText("");
        }
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (id != 0) {
            dto.setCountry(country.getText());
            dto.setCurrency(currency.getText());
            dto.setValue(Double.parseDouble(value.getText()));
            allowanceService.update(dto);

        } else {
            AllowanceDto dto = new AllowanceDto();
            dto.setCountry(country.getText());
            dto.setCurrency(currency.getText());
            dto.setValue(Double.parseDouble(value.getText()));
            allowanceService.add(dto);
        }

        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
