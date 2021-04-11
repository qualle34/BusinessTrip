package com.qualle.trip.controller.list;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.edit.EditTripController;
import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.service.ReportService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import org.springframework.beans.factory.annotation.Autowired;

import static com.qualle.trip.controller.util.ControllerUtil.*;

public class TripListController implements ListController {

    @Autowired
    private ViewHolder tripEditView;

    @Autowired
    private TripService tripService;

    @Autowired
    private ReportService reportService;

    @FXML
    private ListView<Object> list;

    @FXML
    private TextField search;

    @Override
    public void add(ActionEvent event) {
        openWindow(tripEditView, getStage(event));
    }

    @Override
    public void doSearch(KeyEvent event) {
        list.setItems(FXCollections.observableArrayList(search.getText() == null
                ? tripService.getAllSimpleDto()
                : tripService.getSimpleDtoByTitle(search.getText().trim())));
    }

    @Override
    public void delete(ActionEvent event) {
        tripService.delete(((TripSimpleDto) list.getSelectionModel().getSelectedItem()).getId());
        list.getItems().remove(list.getSelectionModel().getSelectedItem());
    }

    @Override
    public void getItem(MouseEvent click) {
        if (click.getClickCount() == 2 && list.getSelectionModel().getSelectedItem() != null) {
            EditTripController tripController = (EditTripController) tripEditView.getController();
            tripController.setId(((TripSimpleDto) list.getSelectionModel().getSelectedItem()).getId());
            openWindow(tripEditView, getStage(click));
        }
    }

    @Override
    public void onShow() {
        list.setItems(FXCollections.observableArrayList(tripService.getAllSimpleDto()));
    }

    @Override
    public void onClose() {
        search.setText(null);
    }

    @Override
    public void doReport(ActionEvent event) {
        long id = ((TripSimpleDto) list.getSelectionModel().getSelectedItem()).getId();

        if (id != 0) {
            try {
                reportService.make(tripService.getFullDtoById(id));

            } catch (Exception e) {
                openModal(getStage(event), "Ошибка!");
            }
        }
    }
}
