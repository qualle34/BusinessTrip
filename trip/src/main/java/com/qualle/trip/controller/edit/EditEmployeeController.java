package com.qualle.trip.controller.edit;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TicketService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import static com.qualle.trip.controller.util.ControllerUtil.getStage;
import static com.qualle.trip.controller.util.ControllerUtil.openModal;

public class EditEmployeeController implements AbstractController {

    private EmployeeDto dto;
    private long id;

    @Autowired
    @Qualifier("list")
    private ViewHolder list;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TicketService ticketService;

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
            tickets.setDisable(false);
            trips.setDisable(false);

        } else {
            tickets.setDisable(true);
            trips.setDisable(true);
        }
    }

    @Override
    public void onClose() {
        id = 0;
        dto = null;
        name.setText(null);
        surname.setText(null);
        department.setText(null);
        email.setText(null);
        birthday.setValue(null);
        tickets.setItems(null);
        trips.setItems(null);
        list.getController().onShow();
    }

    @Override
    public boolean validate() {
        return !name.getText().isEmpty() && !email.getText().isEmpty();
    }

    @FXML
    public void getTrip(MouseEvent event) {

        try {
            long tripId = trips.getSelectionModel().getSelectedItem().getId();
            tickets.setItems(FXCollections.observableArrayList(ticketService.getDtoByEmployeeAndTrip(dto.getId(), tripId)));
        } catch (NullPointerException ignore) {
        }
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (!validate()) {
            openModal(getStage(event));
            return;
        }

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

        onClose();
        getStage(event).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
