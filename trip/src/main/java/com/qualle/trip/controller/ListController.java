package com.qualle.trip.controller;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.controller.edit.EditAllowanceController;
import com.qualle.trip.controller.edit.EditEmployeeController;
import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.service.AllowanceService;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TicketService;
import com.qualle.trip.service.TripService;
import com.qualle.trip.service.enums.Type;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

public class ListController {

    private Type type;

    @Qualifier("allowanceEditView")
    @Autowired
    private ControllerConfig.ViewHolder allowanceEditView;

//    @Qualifier("ticketEditView")
//    @Autowired
//    private ControllerConfig.ViewHolder ticketEditView;
//
//    @Qualifier("tripEditView")
//    @Autowired
//    private ControllerConfig.ViewHolder tripEditView;

    @Qualifier("employeeEditView")
    @Autowired
    private ControllerConfig.ViewHolder employeeEditView;

    @Autowired
    private AllowanceService allowanceService;

    @Autowired
    private TicketService ticketService;

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
            case ALLOWANCE:
                pageTitle.setText("Размеры возмещения расходов при командировках");
                list.setItems(FXCollections.observableArrayList(allowanceService.getAllDto()));
                break;
            case TICKET:
                pageTitle.setText("Список всех билетов");
                list.setItems(FXCollections.observableArrayList(ticketService.getAllDto()));
                break;
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

    public void setType(Type type) {
        this.type = type;
    }

    @FXML
    public void getItem(MouseEvent click) {

        if (click.getClickCount() == 2) {
            ListView listView = (ListView) click.getSource();
            Stage dialog = new Stage();

            switch (type) {
                case ALLOWANCE:
                    try {
                        EditAllowanceController controller = (EditAllowanceController) allowanceEditView.getController();
                        EmployeeSimpleDto dto = (EmployeeSimpleDto) list.getSelectionModel().getSelectedItem();
                        controller.setAllowanceId(dto.getId());
                    } catch (NullPointerException ignore) {
                    }

                    if (allowanceEditView.getView().getScene() != null) {

                        dialog.setScene(allowanceEditView.getView().getScene());
                    } else {
                        dialog.setScene(new Scene(allowanceEditView.getView()));
                    }
                    break;

//                case TICKET:
//                    if (ticketEditView.getView().getScene() != null) {
//                        dialog.setScene(ticketEditView.getView().getScene());
//                    } else {
//                        dialog.setScene(new Scene(ticketEditView.getView()));
//                    }
//                    break;
//
//                case TRIP:
//                    if (tripEditView.getView().getScene() != null) {
//                        dialog.setScene(tripEditView.getView().getScene());
//                    } else {
//                        dialog.setScene(new Scene(tripEditView.getView()));
//                    }
//                    break;

                case EMPLOYEE:
                    try {
                        EditEmployeeController controller = (EditEmployeeController) employeeEditView.getController();
                        EmployeeSimpleDto dto = (EmployeeSimpleDto) list.getSelectionModel().getSelectedItem();
                        controller.setEmployeeId(dto.getId());
                    } catch (NullPointerException ignore) {
                    }

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
