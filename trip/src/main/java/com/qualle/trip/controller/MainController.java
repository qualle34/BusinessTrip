package com.qualle.trip.controller;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

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

    @Qualifier("tripAddView")
    @Autowired
    private ControllerConfig.ViewHolder tripAddView;

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
        Button button = (Button) event.getSource();
        Stage dialog = new Stage();

        if (tripAddView.getView().getScene() != null) {
            dialog.setScene(tripAddView.getView().getScene());
        } else {
            dialog.setScene(new Scene(tripAddView.getView()));
        }

        dialog.initOwner(button.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }

    @FXML
    public void showAllowance(ActionEvent event) {
        showList(event, allowanceListView);
    }

    @FXML
    public void showTickets(ActionEvent event) {
        showList(event, ticketListView);
    }

    @FXML
    public void showTrips(ActionEvent event) {
        showList(event, tripListView);
    }

    @FXML
    public void showEmployees(ActionEvent event) {
        showList(event, employeeListView);
    }


    private void showList(ActionEvent event, ControllerConfig.ViewHolder viewHolder) {
        Button button = (Button) event.getSource();
        Stage dialog = new Stage();
        ListController controller = (ListController) viewHolder.getController();
        dialog.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> controller.onShow());

        if (viewHolder.getView().getScene() != null) {
            dialog.setScene(viewHolder.getView().getScene());
        } else {
            dialog.setScene(new Scene(viewHolder.getView()));
        }

        dialog.initOwner(button.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }
}
