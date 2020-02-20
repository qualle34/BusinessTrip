package com.qualle.trip.config;

import com.qualle.trip.controller.EditController;
import com.qualle.trip.controller.ListController;
import com.qualle.trip.controller.LoginController;
import com.qualle.trip.controller.MainController;
import com.qualle.trip.service.enums.ListType;
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

    @Bean(name = "tripListView")
    public ViewHolder getTripListView() throws IOException {
        return loadView("templates/list.fxml");
    }

    @Bean(name = "employeeListView")
    public ViewHolder getEmployeeListView() throws IOException {
        return loadView("templates/list.fxml");
    }

    @Bean(name = "loginView")
    public ViewHolder getLoginView() throws IOException {
        return loadView("templates/login.fxml");
    }

    @Bean(name = "allowanceEditView")
    public ViewHolder getAllowanceEditView() throws IOException {
        return loadView("templates/edit.fxml");
    }

    @Bean(name = "employeeEditView")
    public ViewHolder getEmployeeEditView() throws IOException {
        return loadView("templates/edit.fxml");
    }

    @Bean(name = "tripEditView")
    public ViewHolder getTripEditView() throws IOException {
        return loadView("templates/edit.fxml");
    }

    @Bean
    public MainController getMainController() throws IOException {
        return (MainController) getMainView().getController();
    }

    @Bean
    public ListController getTripListController() throws IOException {
        ListController controller = (ListController) getTripListView().getController();
        controller.setType(ListType.TRIP);
        return controller;
    }

    @Bean
    public ListController getEmployeeListController() throws IOException {
        ListController controller = (ListController) getEmployeeListView().getController();
        controller.setType(ListType.EMPLOYEE);
        return controller;
    }

    @Bean
    public LoginController getLoginController() throws IOException {
        return (LoginController) getLoginView().getController();
    }

    @Bean
    public EditController getAllowanceEditController() throws IOException {
        EditController controller = (EditController) getAllowanceEditView().getController();
        controller.setType(ListType.ALLOWANCE);
        return controller;
    }

    @Bean
    public EditController getEmployeeEditController() throws IOException {
        EditController controller = (EditController) getAllowanceEditView().getController();
        controller.setType(ListType.EMPLOYEE);
        return controller;
    }

    @Bean
    public EditController getTripEditController() throws IOException {
        EditController controller = (EditController) getAllowanceEditView().getController();
        controller.setType(ListType.TRIP);
        return controller;
    }
}
