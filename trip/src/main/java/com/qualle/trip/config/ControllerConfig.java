package com.qualle.trip.config;

import com.qualle.trip.controller.ListController;
import com.qualle.trip.controller.MainController;
import com.qualle.trip.controller.edit.EditAllowanceController;
import com.qualle.trip.controller.edit.EditEmployeeController;
import com.qualle.trip.controller.edit.EditTicketController;
import com.qualle.trip.controller.edit.EditTripController;
import com.qualle.trip.service.enums.Type;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ControllerConfig {

    protected ViewHolder loadView(String path) throws IOException {
        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream(path)) {
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new ViewHolder(loader.getRoot(), loader.getController());
        }
    }

    public class ViewHolder {
        private Parent view;
        private Object controller;

        public ViewHolder(Parent view, Object controller) {
            this.view = view;
            this.controller = controller;
        }

        public Parent getView() {
            return view;
        }

        public void setView(Parent view) {
            this.view = view;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }
    }

    @Bean(name = "mainView")
    public ViewHolder getMainView() throws IOException {
        return loadView("templates/main.fxml");
    }

    @Bean(name = "allowanceListView")
    public ViewHolder getAllowanceListView() throws IOException {
        return loadView("templates/list.fxml");
    }

    @Bean(name = "ticketListView")
    public ViewHolder getTicketListView() throws IOException {
        return loadView("templates/list.fxml");
    }

    @Bean(name = "tripListView")
    public ViewHolder getTripListView() throws IOException {
        return loadView("templates/list.fxml");
    }

    @Bean(name = "employeeListView")
    public ViewHolder getEmployeeListView() throws IOException {
        return loadView("templates/list.fxml");
    }

    @Bean(name = "allowanceEditView")
    public ViewHolder getAllowanceEditView() throws IOException {
        return loadView("templates/allowance_edit.fxml");
    }

    @Bean(name = "ticketEditView")
    public ViewHolder getTicketEditView() throws IOException {
        return loadView("templates/ticket_edit.fxml");
    }

    @Bean(name = "tripEditView")
    public ViewHolder getTripEditView() throws IOException {
        return loadView("templates/trip_edit.fxml");
    }

    @Bean(name = "employeeEditView")
    public ViewHolder getEmployeeEditView() throws IOException {
        return loadView("templates/employee_edit.fxml");
    }

    @Bean
    public MainController getMainController() throws IOException {
        return (MainController) getMainView().getController();
    }

    @Bean
    public ListController getAllowanceListController() throws IOException {
        ListController controller = (ListController) getAllowanceListView().getController();
        controller.setType(Type.ALLOWANCE);
        return controller;
    }

    @Bean
    public ListController getTicketListController() throws IOException {
        ListController controller = (ListController) getTicketListView().getController();
        controller.setType(Type.TICKET);
        return controller;
    }

    @Bean
    public ListController getTripListController() throws IOException {
        ListController controller = (ListController) getTripListView().getController();
        controller.setType(Type.TRIP);
        return controller;
    }

    @Bean
    public ListController getEmployeeListController() throws IOException {
        ListController controller = (ListController) getEmployeeListView().getController();
        controller.setType(Type.EMPLOYEE);
        return controller;
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
}
