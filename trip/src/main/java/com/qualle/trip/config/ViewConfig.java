package com.qualle.trip.config;

import javafx.fxml.FXMLLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class ViewConfig {

    @Bean
    public ViewHolder mainView() throws IOException {
        return loadView("templates/main.fxml");
    }

    @Bean
    public ViewHolder allowanceListView() throws IOException {
        return loadView("templates/allowance_list.fxml");
    }

    @Bean
    public ViewHolder ticketListView() throws IOException {
        return loadView("templates/ticket_list.fxml");
    }

    @Bean
    public ViewHolder tripListView() throws IOException {
        return loadView("templates/trip_list.fxml");
    }

    @Bean
    public ViewHolder employeeListView() throws IOException {
        return loadView("templates/employee_list.fxml");
    }

    @Bean
    public ViewHolder allowanceEditView() throws IOException {
        return loadView("templates/allowance_edit.fxml");
    }

    @Bean
    public ViewHolder ticketEditView() throws IOException {
        return loadView("templates/ticket_edit.fxml");
    }

    @Bean
    public ViewHolder tripEditView() throws IOException {
        return loadView("templates/trip_edit.fxml");
    }

    @Bean
    public ViewHolder employeeEditView() throws IOException {
        return loadView("templates/employee_edit.fxml");
    }

    @Bean
    public ViewHolder memberEditView() throws IOException {
        return loadView("templates/member_edit.fxml");
    }

    @Bean
    public ViewHolder memberAddView() throws IOException {
        return loadView("templates/member_add.fxml");
    }

    @Bean
    public ViewHolder tripAddView() throws IOException {
        return loadView("templates/trip_add.fxml");
    }

    private ViewHolder loadView(String path) throws IOException {
        try (InputStream fxmlStream = getClass().getClassLoader().getResourceAsStream(path)) {
            FXMLLoader loader = new FXMLLoader();
            loader.load(fxmlStream);
            return new ViewHolder(loader.getRoot(), loader.getController());
        }
    }
}
