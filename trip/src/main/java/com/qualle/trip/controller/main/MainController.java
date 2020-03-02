package com.qualle.trip.controller.main;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import com.qualle.trip.service.enums.PageType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

import static com.qualle.trip.controller.util.ControllerUtil.openWindow;

public class MainController implements AbstractController {

    @Qualifier("list")
    @Autowired
    private ViewHolder listView;

    @Qualifier("tripAdd")
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
        Button button = (Button) event.getSource();
        openWindow(tripAddView, (Stage) button.getScene().getWindow());
    }

    @FXML
    public void showAllowance(ActionEvent event) {
        showList(event, PageType.ALLOWANCE);
    }

    @FXML
    public void showTickets(ActionEvent event) {
        showList(event, PageType.TICKET);
    }

    @FXML
    public void showTrips(ActionEvent event) {
        showList(event, PageType.TRIP);
    }

    @FXML
    public void showEmployees(ActionEvent event) {
        showList(event, PageType.EMPLOYEE);
    }

    private void showList(ActionEvent event, PageType type) {
        Button button = (Button) event.getSource();
        ListController controller = (ListController) listView.getController();
        controller.setType(type);
        openWindow(listView, (Stage) button.getScene().getWindow());
    }

    @Override
    public void onShow() {
    }

    @Override
    public void onClose() {
    }
}
