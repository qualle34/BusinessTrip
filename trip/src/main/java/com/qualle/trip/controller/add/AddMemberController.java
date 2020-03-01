package com.qualle.trip.controller.add;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.controller.util.ControllerUtil;
import com.qualle.trip.model.dto.*;
import com.qualle.trip.service.AllowanceService;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.TicketService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

public class AddMemberController implements AbstractController {

    private MemberDto dto;

    @Qualifier("tripAdd")
    @Autowired
    private ViewHolder tripAddView;

    @Qualifier("ticketEdit")
    @Autowired
    private ViewHolder ticketEditView;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AllowanceService allowanceService;

    @FXML
    public ComboBox<EmployeeSimpleDto> employee;

    @FXML
    public TextField role;

    @FXML
    public ListView<TicketDto> tickets;

    @FXML
    public ComboBox<TicketDto> ticket;

    @FXML
    public ListView<MemberAllowanceDto> allowances;

    @FXML
    public ComboBox<AllowanceDto> allowance;

    @PostConstruct
    public void init() {
        employee.setItems(FXCollections.observableArrayList(employeeService.getAllSimpleDto()));
        ticket.setItems(FXCollections.observableArrayList(ticketService.getAllDto()));
        allowance.setItems(FXCollections.observableArrayList(allowanceService.getAllDto()));
        newDto();
    }

    @FXML
    public void addTicket(ActionEvent event) {
        if (ticket.getValue() != null) {
            dto.getTickets().add(ticket.getValue());
        }
        refresh();
    }

    @FXML
    public void createTicket(ActionEvent event) {
        ControllerUtil.openWindow(ticketEditView, (Stage) ((Button) event.getSource()).getScene().getWindow());
    }

    @FXML
    public void addAllowance(ActionEvent event) {
        if (allowance.getValue() == null) {
            return;
        }
        Stage stage = new Stage();
        stage.setTitle("Введите количество дней");
        stage.setResizable(false);
        Group root = new Group();
        Scene scene = new Scene(root, 300, 200, Color.WHITE);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 50, 50, 50));
        grid.setVgap(30);
        grid.setPrefWidth(300);
        grid.setPrefHeight(200);


        final TextField days = new TextField("1");
        days.setPromptText("Количество дней");
        days.setPrefWidth(200);
        days.setPrefHeight(30);
        grid.add(days, 1, 1);

        Button approve = new Button("OK");
        approve.setPrefHeight(30);
        approve.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                dto.getAllowances().add(new MemberAllowanceDto(allowance.getValue(), Integer.parseInt(days.getText())));
                refresh();
                stage.close();
            }
        });
        grid.add(approve, 1, 2);
        GridPane.setHalignment(approve, HPos.CENTER);
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void getAllowance(MouseEvent event) {
    }

    @FXML
    public void getTicket(MouseEvent event) {
    }

    @FXML
    public void doApprove(ActionEvent event) {
        dto.setEmployee(new EmployeeDto(employee.getValue()));
        dto.setRole(role.getText());
        AddTripController controller = (AddTripController) tripAddView.getController();
        controller.addMember(dto);
        reset();

        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    private void refresh() {
        tickets.setItems(FXCollections.observableArrayList(dto.getTickets()));
        allowances.setItems(FXCollections.observableArrayList(dto.getAllowances()));
    }

    private void reset() {
        newDto();
        employee.setValue(null);
        role.setText(null);
        tickets.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        ticket.setValue(null);
        allowances.setItems(FXCollections.observableArrayList(new ArrayList<>()));
        allowance.setValue(null);
    }

    private void newDto() {
        dto = new MemberDto();
        dto.setTickets(new ArrayList<>());
        dto.setAllowances(new ArrayList<>());
    }

    @Override
    public void onShow() {

    }
}
