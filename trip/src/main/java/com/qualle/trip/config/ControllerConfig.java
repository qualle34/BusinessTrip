package com.qualle.trip.config;

import com.qualle.trip.controller.add.AddMemberController;
import com.qualle.trip.controller.add.AddTripController;
import com.qualle.trip.controller.edit.*;
import com.qualle.trip.controller.main.ListController;
import com.qualle.trip.controller.main.MainController;
import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ControllerConfig {

    @Bean(name = "main")
    public ViewHolder getMainView() throws IOException {
        return loadView("templates/main.fxml");
    }

    @Bean(name = "list")
    public ViewHolder getListView() throws IOException {
        return loadView("templates/list.fxml");
    }

    @Bean(name = "allowanceEdit")
    public ViewHolder getAllowanceEditView() throws IOException {
        return loadView("templates/allowance_edit.fxml");
    }

    @Bean(name = "ticketEdit")
    public ViewHolder getTicketEditView() throws IOException {
        return loadView("templates/ticket_edit.fxml");
    }

    @Bean(name = "tripEdit")
    public ViewHolder getTripEditView() throws IOException {
        return loadView("templates/trip_edit.fxml");
    }

    @Bean(name = "employeeEdit")
    public ViewHolder getEmployeeEditView() throws IOException {
        return loadView("templates/employee_edit.fxml");
    }

    @Bean(name = "memberEdit")
    public ViewHolder getMemberEditView() throws IOException {
        return loadView("templates/member_edit.fxml");
    }

    @Bean(name = "memberAdd")
    public ViewHolder getMemberAddView() throws IOException {
        return loadView("templates/member_add.fxml");
    }

    @Bean(name = "tripAdd")
    public ViewHolder getTripAddView() throws IOException {
        return loadView("templates/trip_add.fxml");
    }

    @Bean
    public MainController getMainController() throws IOException {
        return (MainController) getMainView().getController();
    }

    @Bean
    public ListController getListController() throws IOException {
        return (ListController) getListView().getController();
    }

    @Bean
    public EditAllowanceController getAllowanceEditController() throws IOException {
        return (EditAllowanceController) getAllowanceEditView().getController();
    }

    @Bean
    public EditTicketController getTicketEditController() throws IOException {
        return (EditTicketController) getTicketEditView().getController();
    }

    @Bean
    public EditTripController getTripEditController() throws IOException {
        return (EditTripController) getTripEditView().getController();
    }

    @Bean
    public EditEmployeeController getEmployeeEditController() throws IOException {
        return (EditEmployeeController) getEmployeeEditView().getController();
    }

    @Bean
    public EditMemberController getMemberEditController() throws IOException {
        return (EditMemberController) getMemberEditView().getController();
    }

    @Bean
    public AddMemberController getMemberAddController() throws IOException {
        return (AddMemberController) getMemberAddView().getController();
    }

    @Bean
    public AddTripController getTripAddController() throws IOException {
        return (AddTripController) getTripAddView().getController();
    }

    private ViewHolder loadView(String path) throws IOException {
        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream(path)) {
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new ViewHolder(loader.getRoot(), loader.getController());
        }
    }
}
