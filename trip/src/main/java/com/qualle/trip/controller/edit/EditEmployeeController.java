package com.qualle.trip.controller.edit;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.awt.event.WindowEvent;

public class EditEmployeeController {

    private long employeeId;

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
    private CheckBox isRelevant;

    @FXML
    private ListView<TripSimpleDto> trips;

    @FXML
    private ListView<TicketDto> tickets;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
    }

    public void doApprove(ActionEvent event) {
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public void onMove(WindowEvent event) {
        if (employeeId != 0 && event.equals(WindowEvent.WINDOW_OPENED)) {
            EmployeeDto dto = employeeService.getDtoById(employeeId);
            name.setText(dto.getName());
            surname.setText(dto.getSurname());
            department.setText(dto.getDepartment());
            email.setText(dto.getEmail());
            birthday.setValue(dto.getBirthday());
            isRelevant.setSelected(dto.isRelevant());
            trips.setItems(FXCollections.observableArrayList(tripService.getAllSimpleDtoByEmployee(employeeId)));
        }
    }
}
