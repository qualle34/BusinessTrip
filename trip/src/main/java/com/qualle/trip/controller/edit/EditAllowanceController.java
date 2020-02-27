package com.qualle.trip.controller.edit;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.service.AllowanceService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

public class EditAllowanceController {

    private long id;

    private AllowanceDto dto;

    @Autowired
    private AllowanceService allowanceService;

    @FXML
    private TextField country;

    @FXML
    private TextField value;

    @FXML
    private TextField currency;

    public void doApprove(ActionEvent event) {

        if (id != 0) {
            AllowanceDto after = dto;
            after.setCountry(country.getText());
            after.setCurrency(currency.getText());
            after.setValue(Double.parseDouble(value.getText()));

            allowanceService.update(dto);

        } else {
            AllowanceDto dto = new AllowanceDto();
            dto.setCountry(country.getText());
            dto.setCurrency(currency.getText());
            dto.setValue(Double.parseDouble(value.getText()));
            allowanceService.add(dto);
        }
        reset();

        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public void onShow() {
        if (id != 0) {
            dto = allowanceService.getDtoById(id);
            country.setText(dto.getCountry());
            value.setText(String.valueOf(dto.getValue()));
            currency.setText(dto.getCurrency());
        } else {
            reset();
        }
    }

    private void reset() {
        dto = null;
        country.setText("");
        value.setText("");
        currency.setText("");
    }

    public void setId(long id) {
        this.id = id;
    }
}
