package com.qualle.trip.controller;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.controller.edit.EditAllowanceController;
import com.qualle.trip.controller.edit.EditEmployeeController;
import com.qualle.trip.controller.edit.EditTicketController;
import com.qualle.trip.controller.edit.EditTripController;
import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.dto.TripSimpleDto;
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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;

public class ListController {

    private Type type;

    @Qualifier("allowanceEditView")
    @Autowired
    private ControllerConfig.ViewHolder allowanceEditView;

    @Qualifier("ticketEditView")
    @Autowired
    private ControllerConfig.ViewHolder ticketEditView;

    @Qualifier("tripEditView")
    @Autowired
    private ControllerConfig.ViewHolder tripEditView;

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
    private TextField search;

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

    @FXML
    public void doSearch(KeyEvent event) {

        switch (type) {
            case ALLOWANCE:
                list.setItems(FXCollections.observableArrayList(search.getText().isEmpty()
                        ? allowanceService.getAllDto()
                        : allowanceService.getDtoByCountry(search.getText())));
                break;
            case TICKET:
                list.setItems(FXCollections.observableArrayList(search.getText().isEmpty()
                        ? ticketService.getAllDto()
                        : ticketService.getDtoByLocation(search.getText())));
                break;
            case TRIP:
                list.setItems(FXCollections.observableArrayList(search.getText().isEmpty()
                        ? tripService.getAllSimpleDto()
                        : tripService.getSimpleDtoByTitle(search.getText())));
                break;
            case EMPLOYEE:
                list.setItems(FXCollections.observableArrayList(search.getText().isEmpty()
                        ? employeeService.getAllDto()
                        : employeeService.getSimpleDtoByName(search.getText())));
                break;
        }
    }

    @FXML
    public void getItem(MouseEvent click) {

        if (click.getClickCount() == 2) {
            ListView listView = (ListView) click.getSource();
            Stage dialog = new Stage();
            dialog.setResizable(false);

            switch (type) {
                case ALLOWANCE:

                    EditAllowanceController allowanceController = (EditAllowanceController) allowanceEditView.getController();
                    allowanceController.setId(((AllowanceDto) list.getSelectionModel().getSelectedItem()).getId());
                    dialog.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> allowanceController.onShow());

                    setScene(dialog, allowanceEditView);
                    break;

                case TICKET:

                    EditTicketController ticketController = (EditTicketController) ticketEditView.getController();
                    ticketController.setId(((TicketDto) list.getSelectionModel().getSelectedItem()).getId());
                    dialog.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> ticketController.onShow());

                    setScene(dialog, ticketEditView);
                    break;

                case TRIP:

                    EditTripController tripController = (EditTripController) tripEditView.getController();
                    tripController.setId(((TripSimpleDto) list.getSelectionModel().getSelectedItem()).getId());
                    dialog.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> tripController.onShow());

                    setScene(dialog, tripEditView);
                    break;

                case EMPLOYEE:

                    EditEmployeeController employeeController = (EditEmployeeController) employeeEditView.getController();
                    employeeController.setId(((EmployeeSimpleDto) list.getSelectionModel().getSelectedItem()).getId());
                    dialog.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> employeeController.onShow());

                    setScene(dialog, employeeEditView);
                    break;
            }

            dialog.initOwner(listView.getScene().getWindow());
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.showAndWait();
        }
    }

    private void setScene(Stage dialog, ControllerConfig.ViewHolder viewHolder) {
        if (viewHolder.getView().getScene() != null) {
            dialog.setScene(viewHolder.getView().getScene());
        } else {
            dialog.setScene(new Scene(viewHolder.getView()));
        }
    }

    public void setType(Type type) {
        this.type = type;
    }
}
