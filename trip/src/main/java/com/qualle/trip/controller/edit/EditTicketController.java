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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.Arrays;

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
    private TextField date;

    @FXML
    private TextField price;

    @FXML
    private ChoiceBox<TicketType> type;

    @FXML
    private ChoiceBox<EmployeeSimpleDto> employee;

    @PostConstruct
    public void init(){
        type.setItems(FXCollections.observableArrayList(Arrays.asList(TicketType.values())));
        employee.setItems(FXCollections.observableArrayList(employeeService.getAllSimpleDto()));
    }

    @Override
    public void onShow() {

        if (id != 0) {
            dto = ticketService.getDtoById(id);
            from.setText(dto.getFrom());
            to.setText(dto.getTo());
            date.setText(dto.getDate().toString());
            price.setText(String.valueOf(dto.getPrice()));
            type.setValue(dto.getType());
            employee.setValue(dto.getEmployee());

        } else {
            dto = null;
            from.setText(null);
            to.setText(null);
            date.setText(null);
            price.setText(null);
            type.setValue(null);
            employee.setValue(null);
        }
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (id != 0) {
            dto.setFrom(from.getText());
            dto.setTo(to.getText());
//        dto.setDate(date);
            dto.setPrice(Double.parseDouble(price.getText()));
            dto.setType(type.getValue());
//        dto.setEmployee();
            ticketService.update(dto);

        } else {
            dto = new TicketDto();
            dto.setFrom(from.getText());
            dto.setTo(to.getText());
//        dto.setDate(date);
            dto.setPrice(Double.parseDouble(price.getText()));
            dto.setType(type.getValue());
//        dto.setEmployee();
            ticketService.add(dto);
        }

        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
