package com.qualle.trip.controller.main;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.BaseController;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

import static com.qualle.trip.controller.util.ControllerUtil.getStage;
import static com.qualle.trip.controller.util.ControllerUtil.openWindow;

public class MainController implements BaseController {

    @Autowired
    private ViewHolder allowanceListView;

    @Autowired
    private ViewHolder ticketListView;

    @Autowired
    private ViewHolder tripListView;

    @Autowired
    private ViewHolder employeeListView;

    @Autowired
    private ViewHolder tripAddView;

    @Autowired
    private TripService tripService;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private ListView<EmployeeSimpleDto> employeeList;

    @FXML
    private ListView<TripSimpleDto> tripList;

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
    public void add(ActionEvent event) {
        openWindow(tripAddView, getStage(event));
    }

    @FXML
    public void showAllowance(ActionEvent event) {
        openWindow(allowanceListView, getStage(event));
    }

    @FXML
    public void showTickets(ActionEvent event) {
        openWindow(ticketListView, getStage(event));
    }

    @FXML
    public void showTrips(ActionEvent event) {
        openWindow(tripListView, getStage(event));
    }

    @FXML
    public void showEmployees(ActionEvent event) {
        openWindow(employeeListView, getStage(event));
    }

    @Override
    public void onShow() {
    }

    @Override
    public void onClose() {
    }

    @Override
    public boolean validate() {
        return true;
    }
}
