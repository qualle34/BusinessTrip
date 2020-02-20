package com.qualle.trip.controller;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TripService;
import com.qualle.trip.service.enums.ListType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

public class ListController {

    private ListType type;

    @Qualifier("tripEditView")
    @Autowired
    private ControllerConfig.ViewHolder tripEditView;

    @Qualifier("employeeEditView")
    @Autowired
    private ControllerConfig.ViewHolder employeeEditView;

    @Autowired
    private TripService tripService;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private ListView<Object> list;

    @FXML
    private Label pageTitle;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
        switch (type) {
            case TRIP:
                pageTitle.setText("Список всех командировок");
                list.setItems(FXCollections.observableArrayList(tripService.getAllSimpleDto()));
                break;
            case EMPLOYEE:
                pageTitle.setText("Список всех сотрудников");
                list.setItems(FXCollections.observableArrayList(employeeService.getAllSimpleDto()));
                break;
        }
    }

    @FXML
    public void add(ActionEvent event) {

    }

    public void setType(ListType type) {
        this.type = type;
    }

    @FXML
    public void getItem(MouseEvent click) {

        if (click.getClickCount() == 2) {
            ListView listView = (ListView) click.getSource();
            Stage dialog = new Stage();

            switch (type) {
                case TRIP:
                    if (tripEditView.getView().getScene() != null) {
                        dialog.setScene(tripEditView.getView().getScene());
                    } else {
                        dialog.setScene(new Scene(tripEditView.getView()));
                    }
                    break;

                case EMPLOYEE:
                    if (employeeEditView.getView().getScene() != null) {
                        dialog.setScene(employeeEditView.getView().getScene());
                    } else {
                        dialog.setScene(new Scene(employeeEditView.getView()));
                    }
                    break;
            }

            dialog.initOwner(listView.getScene().getWindow());
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.showAndWait();
        }
    }
}
