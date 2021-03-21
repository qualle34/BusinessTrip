package com.qualle.trip.controller.edit;

import com.qualle.trip.controller.BaseController;
import com.qualle.trip.controller.list.TicketListController;
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
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.Date;

import static com.qualle.trip.controller.util.ControllerUtil.*;

public class EditTicketController implements BaseController {

    private TicketDto dto;
    private long id;

    @Autowired
    private TicketListController ticketListController;

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
    private TextField price;

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
            price.setText(String.valueOf(dto.getPrice()));
            type.setValue(dto.getType());
            employee.setValue(dto.getEmployee());
        } else {
            date.setValue(getDate(new Date()));
            time.setText(getTime(new Date()));
        }
    }

    @Override
    public void onClose() {
        id = 0;
        dto = null;
        from.setText(null);
        to.setText(null);
        date.setValue(null);
        time.setText(null);
        price.setText(null);
        type.setValue(null);
        employee.setValue(null);
        ticketListController.onShow();
    }

    @Override
    public boolean validate() {
        return !from.getText().isEmpty() && !to.getText().isEmpty() && date.getValue() != null &&
                !price.getText().isEmpty() && type.getValue() != null && validateTime(time.getText());
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
            dto.setPrice(Double.parseDouble(price.getText()));
            dto.setType(type.getValue());
            ticketService.update(dto);

        } else {
            dto = new TicketDto();
            dto.setFrom(from.getText());
            dto.setTo(to.getText());
            dto.setDate(toDate(date.getValue(), time.getText()));
            dto.setPrice(Double.parseDouble(price.getText()));
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
