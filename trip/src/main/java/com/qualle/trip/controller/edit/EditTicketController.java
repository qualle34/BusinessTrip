package com.qualle.trip.controller.edit;

import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.enums.TicketType;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TicketService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;

import static com.qualle.trip.controller.util.ControllerUtil.*;

public class EditTicketController implements AbstractController {

    private TicketDto dto;
    private long id;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private TextField from;

    @FXML
    private TextField to;

    @FXML
    private DatePicker date;

    @FXML
    private TextField time;

    @FXML
    private Spinner<Double> price;

    @FXML
    private ChoiceBox<TicketType> type;

    @FXML
    private ChoiceBox<EmployeeSimpleDto> employee;

    @PostConstruct
    public void init() {
        type.setItems(FXCollections.observableArrayList(Arrays.asList(TicketType.values())));
    }

    @Override
    public void onShow() {
        employee.setItems(FXCollections.observableArrayList(employeeService.getAllSimpleDto()));
        employee.setDisable(true);

        if (id != 0) {
            dto = ticketService.getFullDtoById(id);
            from.setText(dto.getFrom());
            to.setText(dto.getTo());
            date.setValue(getDate(dto.getDate()));
            time.setText(getTime(dto.getDate()));
            price.setValueFactory(getSpinnerFactory(dto.getPrice()));
            type.setValue(dto.getType());
            employee.setValue(dto.getEmployee());

        } else {
            price.setValueFactory(getSpinnerFactory(0.0));
        }
    }

    @Override
    public void onClose() {
        id = 0;
        dto = null;
        from.setText(null);
        to.setText(null);
        date.setValue(null);
        type.setValue(null);
        employee.setValue(null);
    }

    @Override
    public boolean validate() {
        return !from.getText().isEmpty() && !to.getText().isEmpty() && date.getValue() != null &&
               price.getValue() != null && type.getValue() != null && validateTime(time.getText());
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (!validate()) {
            openModal(getStage(event));
            return;
        }

        if (id != 0) {
            dto.setFrom(from.getText());
            dto.setTo(to.getText());
            dto.setDate(toDate(date.getValue(), time.getText()));
            dto.setPrice(price.getValue());
            dto.setType(type.getValue());
            ticketService.update(dto);

        } else {
            dto = new TicketDto();
            dto.setFrom(from.getText());
            dto.setTo(to.getText());
            dto.setDate(toDate(date.getValue(), time.getText()));
            dto.setPrice(price.getValue());
            dto.setType(type.getValue());
            ticketService.add(dto);
        }

        onClose();
        getStage(event).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
