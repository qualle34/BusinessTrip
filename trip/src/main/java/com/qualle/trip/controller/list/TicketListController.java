package com.qualle.trip.controller.list;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.edit.EditTicketController;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.service.TicketService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import static com.qualle.trip.controller.util.ControllerUtil.getStage;
import static com.qualle.trip.controller.util.ControllerUtil.openWindow;

public class TicketListController implements ListController {

    @Autowired
    private ViewHolder ticketEditView;

    @Autowired
    private TicketService ticketService;

    @FXML
    private ListView<Object> list;

    @FXML
    private TextField search;

    @Override
    public void add(ActionEvent event) {
        openWindow(ticketEditView, getStage(event));
    }

    @Override
    public void doSearch(KeyEvent event) {
        list.setItems(FXCollections.observableArrayList(search.getText() == null
                ? ticketService.getAllDto()
                : ticketService.getDtoByLocation(search.getText().trim())));
    }

    @Override
    public void delete(ActionEvent event) {
        ticketService.delete(((TicketDto) list.getSelectionModel().getSelectedItem()).getId());
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
    }

    @Override
    public void getItem(MouseEvent click) {
        if (click.getClickCount() == 2 && list.getSelectionModel().getSelectedItem() != null) {
            EditTicketController ticketController = (EditTicketController) ticketEditView.getController();
            ticketController.setId(((TicketDto) list.getSelectionModel().getSelectedItem()).getId());
            openWindow(ticketEditView, getStage(click));
        }
    }

    @Override
    public void onShow() {
        list.setItems(FXCollections.observableArrayList(ticketService.getAllDto()));
    }

    @Override
    public void onClose() {
        search.setText(null);
    }

    @Override
    public void doReport(ActionEvent event) {
    }
}