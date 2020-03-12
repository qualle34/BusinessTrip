package com.qualle.trip.controller.edit;

import com.qualle.trip.config.ViewHolder;
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
import org.springframework.beans.factory.annotation.Qualifier;

import static com.qualle.trip.controller.util.ControllerUtil.*;

public class EditAllowanceController implements AbstractController {

    private AllowanceDto dto;
    private long id;

    @Autowired
    @Qualifier("list")
    private ViewHolder list;

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

        } else {
            value.setValueFactory(getSpinnerFactory(0.0));
        }
    }

    @Override
    public void onClose() {
        id = 0;
        dto = null;
        country.setText(null);
        value.setValueFactory(getSpinnerFactory(0.0));
        currency.setText(null);
        list.getController().onShow();
    }

    @Override
    public boolean validate() {
        return !country.getText().isEmpty() && value.getValue() != null && !currency.getText().isEmpty();
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (!validate()) {
            openModal(getStage(event));
            return;
        }

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

        onClose();
        getStage(event).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
