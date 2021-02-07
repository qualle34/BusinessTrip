package com.qualle.trip.controller.list;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.edit.EditEmployeeController;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.service.EmployeeService;
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

public class EmployeeListController implements ListController {

    @Autowired
    private ViewHolder employeeEditView;

    @Autowired
    private EmployeeService employeeService;

    @FXML
    private ListView<Object> list;

    @FXML
    private TextField search;

    @Override
    public void add(ActionEvent event) {
        openWindow(employeeEditView, getStage(event));
    }

    @Override
    public void doSearch(KeyEvent event) {
        list.setItems(FXCollections.observableArrayList(search.getText() == null
                ? employeeService.getAllDto()
                : employeeService.getSimpleDtoByName(search.getText().trim())));
    }

    @Override
    public void delete(ActionEvent event) {
        employeeService.delete(((EmployeeSimpleDto) list.getSelectionModel().getSelectedItem()).getId());
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
    }

    @Override
    public void getItem(MouseEvent click) {
        if (click.getClickCount() == 2 && list.getSelectionModel().getSelectedItem() != null) {
            EditEmployeeController employeeController = (EditEmployeeController) employeeEditView.getController();
            employeeController.setId(((EmployeeSimpleDto) list.getSelectionModel().getSelectedItem()).getId());
            openWindow(employeeEditView, getStage(click));
        }
    }

    @Override
    public void onShow() {
        list.setItems(FXCollections.observableArrayList(employeeService.getAllSimpleDto()));
    }

    @Override
    public void onClose() {
        search.setText(null);
    }

    @Override
    public void doReport(ActionEvent event) {
    }
}
