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
import com.qualle.trip.model.entity.Trip;
import com.qualle.trip.service.AllowanceService;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TicketService;
import com.qualle.trip.service.TripService;
import com.qualle.trip.service.enums.PageType;
import com.qualle.trip.service.util.WordUtil;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

public class ListController {

    private PageType type;

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
    private Button report;

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
        Button button = (Button) event.getSource();
        Stage dialog = new Stage();
        dialog.setResizable(false);

        switch (type) {
            case ALLOWANCE:
                setScene(dialog, allowanceEditView);
                break;

            case TICKET:
                setScene(dialog, ticketEditView);
                break;

            case TRIP:
                setScene(dialog, tripEditView);
                break;

            case EMPLOYEE:
                setScene(dialog, employeeEditView);
                break;
        }

        dialog.initOwner(button.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }

    @FXML
    public void doSearch(KeyEvent event) {

        switch (type) {
            case ALLOWANCE:
                list.setItems(FXCollections.observableArrayList(search.getText().isEmpty()
                        ? allowanceService.getAllDto()
                        : allowanceService.getDtoByCountry(search.getText().trim())));
                break;
            case TICKET:
                list.setItems(FXCollections.observableArrayList(search.getText().isEmpty()
                        ? ticketService.getAllDto()
                        : ticketService.getDtoByLocation(search.getText().trim())));
                break;
            case TRIP:
                list.setItems(FXCollections.observableArrayList(search.getText().isEmpty()
                        ? tripService.getAllSimpleDto()
                        : tripService.getSimpleDtoByTitle(search.getText().trim())));
                break;
            case EMPLOYEE:
                list.setItems(FXCollections.observableArrayList(search.getText().isEmpty()
                        ? employeeService.getAllDto()
                        : employeeService.getSimpleDtoByName(search.getText().trim())));
                break;
        }
    }

    @FXML
    public void delete(ActionEvent event) {

        switch (type) {
            case ALLOWANCE:
                allowanceService.delete(((AllowanceDto) list.getSelectionModel().getSelectedItem()).getId());
                break;

            case TICKET:
                ticketService.delete(((TicketDto) list.getSelectionModel().getSelectedItem()).getId());
                break;

            case TRIP:
                tripService.delete(((TripSimpleDto) list.getSelectionModel().getSelectedItem()).getId());
                break;

            case EMPLOYEE:
                employeeService.delete(((EmployeeSimpleDto) list.getSelectionModel().getSelectedItem()).getId());
                break;
        }
    }

    @FXML
    public void getItem(MouseEvent click) {

        if (click.getClickCount() == 2) {
            ListView<AllowanceDto> listView = (ListView<AllowanceDto>) click.getSource();
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

    public void onShow() {
        if (type.equals(PageType.TRIP)) {
            report.setVisible(true);
        } else {
            report.setVisible(false);
        }
    }

    public void setType(PageType type) {
        this.type = type;
    }

    public void doReport(ActionEvent event) {
        long id = ((TripSimpleDto) list.getSelectionModel().getSelectedItem()).getId();

        if (type.equals(PageType.TRIP) && id != 0) {
            Stage stage = new Stage();
            stage.setTitle("Создание отчёта");
            stage.setResizable(false);
            Group root = new Group();
            Scene scene = new Scene(root, 300, 200, Color.WHITE);

            GridPane grid = new GridPane();
            grid.setPadding(new Insets(20, 50, 50, 50));
            grid.setVgap(30);
            grid.setPrefWidth(300);
            grid.setPrefHeight(200);


            final TextField path = new TextField("D:\\");
            path.setPromptText("Путь к отчёту");
            path.setPrefWidth(200);
            path.setPrefHeight(30);
            grid.add(path, 1, 1);

            Button approve = new Button("OK");
            approve.setPrefHeight(30);
            approve.setOnAction(new EventHandler<ActionEvent>() {

                public void handle(ActionEvent event) {
                    tripService.report(id, path.getText());
                    stage.close();
                }
            });
            grid.add(approve, 1, 2);
            GridPane.setHalignment(approve, HPos.CENTER);
            root.getChildren().add(grid);
            stage.setScene(scene);
            stage.show();
        }
    }
}
