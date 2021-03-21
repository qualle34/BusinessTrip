package com.qualle.trip.controller.list;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.edit.EditAllowanceController;
import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.service.AllowanceService;
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

public class AllowanceListController implements ListController {

    @Autowired
    private ViewHolder allowanceEditView;

    @Autowired
    private AllowanceService allowanceService;

    @FXML
    private ListView<Object> list;

    @FXML
    private TextField search;

    @Override
    public void add(ActionEvent event) {
        openWindow(allowanceEditView, getStage(event));
    }

    @Override
    public void doSearch(KeyEvent event) {
        list.setItems(FXCollections.observableArrayList(search.getText() == null
                ? allowanceService.getAllDto()
                : allowanceService.getDtoByCountry(search.getText().trim())));
    }

    @Override
    public void delete(ActionEvent event) {
        allowanceService.delete(((AllowanceDto) list.getSelectionModel().getSelectedItem()).getId());
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
    }

    @Override
    public void getItem(MouseEvent click) {
        if (click.getClickCount() == 2 && list.getSelectionModel().getSelectedItem() != null) {
            EditAllowanceController allowanceController = (EditAllowanceController) allowanceEditView.getController();
            allowanceController.setId(((AllowanceDto) list.getSelectionModel().getSelectedItem()).getId());
            openWindow(allowanceEditView, getStage(click));
        }
    }

    @Override
    public void onShow() {
        list.setItems(FXCollections.observableArrayList(allowanceService.getAllDto()));
    }

    @Override
    public void onClose() {
        search.setText(null);
    }

    @Override
    public void doReport(ActionEvent event) {
    }
}
