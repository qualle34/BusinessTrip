package com.qualle.trip.controller.edit;

import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.service.EmployeeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

public class EditEmployeeController implements AbstractController {

    private EmployeeDto dto;
    private long id;

    @Autowired
    private EmployeeService employeeService;

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

    @Override
    public void onShow() {

        if (id != 0) {
            dto = employeeService.getFullDtoById(id);
            name.setText(dto.getName());
            surname.setText(dto.getSurname());
            department.setText(dto.getDepartment());
            email.setText(dto.getEmail());
            birthday.setValue(dto.getBirthday());
            if (dto.getTickets() != null) {
                tickets.setItems(FXCollections.observableArrayList(dto.getTickets()));
            }
            if (dto.getTrips() != null) {
                trips.setItems(FXCollections.observableArrayList(dto.getTrips()));
            }

        } else {
            dto = null;
            name.setText(null);
            surname.setText(null);
            department.setText(null);
            email.setText(null);
            birthday.setValue(null);
            tickets.setItems(null);
            trips.setItems(null);
        }
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (id != 0) {
            dto.setName(name.getText());
            dto.setSurname(surname.getText());
            dto.setDepartment(department.getText());
            dto.setEmail(email.getText());
            dto.setBirthday(birthday.getValue());
            employeeService.update(dto);

        } else {
            dto = new EmployeeDto();
            dto.setName(name.getText());
            dto.setSurname(surname.getText());
            dto.setDepartment(department.getText());
            dto.setEmail(email.getText());
            dto.setBirthday(birthday.getValue());
            employeeService.add(dto);
        }

        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
