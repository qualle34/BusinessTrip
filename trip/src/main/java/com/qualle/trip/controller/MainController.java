package com.qualle.trip.controller;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.model.entity.Trip;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import com.qualle.trip.service.util.WordUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class MainController {

    @Qualifier("allowanceListView")
    @Autowired
    private ControllerConfig.ViewHolder allowanceListView;

    @Qualifier("ticketListView")
    @Autowired
    private ControllerConfig.ViewHolder ticketListView;

    @Qualifier("tripListView")
    @Autowired
    private ControllerConfig.ViewHolder tripListView;

    @Qualifier("employeeListView")
    @Autowired
    private ControllerConfig.ViewHolder employeeListView;

    @Autowired
    private TripService tripService;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private ListView<EmployeeSimpleDto> employeeList;

    @FXML
    private ListView<TripSimpleDto> tripList;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
        employeeList.setItems(FXCollections.observableArrayList(employeeService.getAllSimpleDtoByTrip()));
        tripList.setItems(FXCollections.observableArrayList(tripService.getAllSimpleDto()));
    }

    @FXML
    public void reset(ActionEvent event) {
        init();
    }

    @FXML
    public void getEmployee(MouseEvent click) {
        try {
            long id = employeeList.getSelectionModel().getSelectedItem().getId();
            tripList.setItems(FXCollections.observableArrayList(tripService.getAllSimpleDtoByEmployee(id)));
        } catch (NullPointerException ignore) {
        }
    }

    @FXML
    public void getTrip(MouseEvent click) {
        try {
            long id = tripList.getSelectionModel().getSelectedItem().getId();
            employeeList.setItems(FXCollections.observableArrayList(employeeService.getAllSimpleDtoByTrip(id)));
        } catch (NullPointerException ignore) {
        }
    }

    @FXML
    public void addTrip() {
        Trip trip = tripService.getById(1);
        Map<String, String> data = new HashMap<>();
        data.put("title", trip.getTitle());
        data.put("description", trip.getDescription());
        data.put("members", "test, test");
        data.put("expenses", String.valueOf(trip.getAdditionalExpenses()));
        data.put("date_start", trip.getEnd().toString());
        data.put("date_end", trip.getStart().toString());
        WordUtil.createReport("", data);
    }

    @FXML
    public void showAllowance(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage dialog = new Stage();

        if (allowanceListView.getView().getScene() != null) {
            dialog.setScene(allowanceListView.getView().getScene());
        } else {
            dialog.setScene(new Scene(allowanceListView.getView()));
        }

        dialog.initOwner(button.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }

    @FXML
    public void showTickets(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage dialog = new Stage();

        if (ticketListView.getView().getScene() != null) {
            dialog.setScene(ticketListView.getView().getScene());
        } else {
            dialog.setScene(new Scene(ticketListView.getView()));
        }

        dialog.initOwner(button.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }

    @FXML
    public void showTrips(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage dialog = new Stage();

        if (tripListView.getView().getScene() != null) {
            dialog.setScene(tripListView.getView().getScene());
        } else {
            dialog.setScene(new Scene(tripListView.getView()));
        }

        dialog.initOwner(button.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }

    @FXML
    public void showEmployees(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage dialog = new Stage();

        if (employeeListView.getView().getScene() != null) {
            dialog.setScene(employeeListView.getView().getScene());
        } else {
            dialog.setScene(new Scene(employeeListView.getView()));
        }

        dialog.initOwner(button.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }

    @FXML
    public void goToSettings(ActionEvent event) {
    }


}
