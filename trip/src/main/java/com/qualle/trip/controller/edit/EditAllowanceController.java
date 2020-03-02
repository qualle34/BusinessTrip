package com.qualle.trip.controller.edit;

import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.service.AllowanceService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import static com.qualle.trip.controller.util.ControllerUtil.getSpinnerFactory;

public class EditAllowanceController implements AbstractController {

    private AllowanceDto dto;
    private long id;

    @Autowired
    private AllowanceService allowanceService;

    @FXML
    private TextField country;

    @FXML
    private Spinner<Double> value;

    @FXML
    private TextField currency;

    @Override
    public void onShow() {

        if (id != 0) {
            dto = allowanceService.getDtoById(id);
            country.setText(dto.getCountry());
            value.setValueFactory(getSpinnerFactory(dto.getValue()));
            currency.setText(dto.getCurrency());
        }
    }

    @Override
    public void onClose() {
        id = 0;
        dto = null;
        country.setText(null);
        value.setValueFactory(getSpinnerFactory(0.0));
        currency.setText(null);
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (id != 0) {
            dto.setCountry(country.getText());
            dto.setCurrency(currency.getText());
            dto.setValue(value.getValue());
            allowanceService.update(dto);

        } else {
            AllowanceDto dto = new AllowanceDto();
            dto.setCountry(country.getText());
            dto.setCurrency(currency.getText());
            dto.setValue(value.getValue());
            allowanceService.add(dto);
        }

        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
