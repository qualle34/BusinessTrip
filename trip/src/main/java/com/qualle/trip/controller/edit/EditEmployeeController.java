package com.qualle.trip.controller.edit;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class EditEmployeeController {

    private long id;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TripService tripService;

    @FXML
    private TextField name;

    @FXML
    private TextField surname;

    @FXML
    private TextField department;

    @FXML
    private TextField email;

    @FXML
    private DatePicker birthday;

    @FXML
    private ListView<TicketDto> tickets;

    @FXML
    private ListView<TripSimpleDto> trips;

    public void doApprove(ActionEvent event) {
    }

    public void onShow() {
        if (id != 0) {
            EmployeeDto dto = employeeService.getFullDtoById(id);
            name.setText(dto.getName());
            surname.setText(dto.getSurname());
            department.setText(dto.getDepartment());
            email.setText(dto.getEmail());
            birthday.setValue(dto.getBirthday());
            tickets.setItems(FXCollections.observableArrayList(dto.getTickets()));
            trips.setItems(FXCollections.observableArrayList(dto.getTrips()));
        }
    }

    public void setId(long id) {
        this.id = id;
    }
}
