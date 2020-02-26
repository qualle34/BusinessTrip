package com.qualle.trip.controller.edit;

import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.enums.TicketType;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TicketService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class EditTicketController {

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

    public void doApprove(ActionEvent event) {
    }

    public void onShow() {

        if (id != 0) {
            TicketDto dto = ticketService.getDtoById(id);
            from.setText(dto.getFrom());
            to.setText(dto.getTo());
            date.setText(dto.getDate().toString());
            price.setText(String.valueOf(dto.getPrice()));
            type.setItems(FXCollections.observableArrayList(getTypes()));
            type.setValue(dto.getType());
            employee.setItems(FXCollections.observableArrayList(employeeService.getAllSimpleDto()));
            employee.setValue(dto.getEmployee());
        }
    }

    public void setId(long id) {
        this.id = id;
    }

    List<TicketType> getTypes(){
        return Arrays.asList(TicketType.values());
    }
}
