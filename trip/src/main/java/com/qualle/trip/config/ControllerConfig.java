package com.qualle.trip.config;

import com.qualle.trip.controller.BaseController;
import com.qualle.trip.controller.list.ListController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ControllerConfig {

    @Bean
    public BaseController mainController(ViewHolder mainView) {
        return mainView.getController();
    }

    @Bean
    public ListController allowanceListController(ViewHolder allowanceListView) {
        return (ListController) allowanceListView.getController();
    }

    @Bean
    public ListController ticketListController(ViewHolder ticketListView) {
        return (ListController) ticketListView.getController();
    }

    @Bean
    public ListController tripListController(ViewHolder tripListView) {
        return (ListController) tripListView.getController();
    }

    @Bean
    public ListController employeeListController(ViewHolder employeeListView) {
        return (ListController) employeeListView.getController();
    }

    @Bean
    public BaseController allowanceEditController(ViewHolder allowanceEditView) {
        return allowanceEditView.getController();
    }

    @Bean
    public BaseController ticketEditController(ViewHolder ticketEditView) {
        return ticketEditView.getController();
    }

    @Bean
    public BaseController tripEditController(ViewHolder tripEditView) {
        return tripEditView.getController();
    }

    @Bean
    public BaseController employeeEditController(ViewHolder employeeEditView) {
        return employeeEditView.getController();
    }

    @Bean
    public BaseController memberEditController(ViewHolder memberEditView) {
        return memberEditView.getController();
    }

    @Bean
    public BaseController memberAddController(ViewHolder memberAddView) {
        return memberAddView.getController();
    }

    @Bean
    public BaseController tripAddController(ViewHolder tripAddView) {
        return tripAddView.getController();
    }
}
