package com.qualle.trip.controller.edit;

import com.qualle.trip.controller.BaseController;
import com.qualle.trip.controller.list.ListController;
import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.service.AllowanceService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import static com.qualle.trip.controller.util.ControllerUtil.getStage;
import static com.qualle.trip.controller.util.ControllerUtil.openModal;

public class EditAllowanceController implements BaseController {

    private AllowanceDto dto;
    private long id;

    @Autowired
    private ListController allowanceListController;

    @Autowired
    private AllowanceService allowanceService;

    @FXML
    private TextField country;

    @FXML
    private TextField value;

    @Override
    public void onShow() {

        if (id != 0) {
            dto = allowanceService.getDtoById(id);
            country.setText(dto.getCountry());
            value.setText(String.valueOf(dto.getValue()));
        }
    }

    @Override
    public void onClose() {
        id = 0;
        dto = null;
        country.setText(null);
        value.setText(null);
        allowanceListController.onShow();
    }

    @Override
    public boolean validate() {
        return !country.getText().isEmpty() && !value.getText().isEmpty();
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (!validate()) {
            openModal(getStage(event));
            return;
        }

        if (id != 0) {
            dto.setCountry(country.getText());
            dto.setValue(Double.parseDouble(value.getText()));
            allowanceService.update(dto);

        } else {
            AllowanceDto newDto = new AllowanceDto();
            newDto.setCountry(country.getText());
            newDto.setValue(Double.parseDouble(value.getText()));
            allowanceService.add(newDto);
        }

        onClose();
        getStage(event).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
