package com.qualle.trip.config;

import com.qualle.trip.controller.AllowanceController;
import com.qualle.trip.controller.LoginController;
import com.qualle.trip.controller.MainController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ControllerConfig {

    @Bean(name = "mainView")
    public ViewHolder getMainView() throws IOException {
        return loadView("templates/main.fxml");
    }

    @Bean(name = "listView")
    public ViewHolder getListView() throws IOException {
        return loadView("templates/list.fxml");
    }

    @Bean(name = "loginView")
    public ViewHolder getLoginView() throws IOException {
        return loadView("templates/login.fxml");
    }

    @Bean
    public MainController getMainController() throws IOException {
        return (MainController) getMainView().getController();
    }

    @Bean
    public AllowanceController getAllowanceController() throws IOException {
        return (AllowanceController) getListView().getController();
    }

    @Bean
    public LoginController getLoginController() throws IOException {
        return (LoginController) getLoginView().getController();
    }

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
}
