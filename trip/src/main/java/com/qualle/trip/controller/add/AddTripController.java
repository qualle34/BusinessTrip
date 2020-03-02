package com.qualle.trip.controller.add;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.controller.util.ControllerUtil;
import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.Date;

import static com.qualle.trip.controller.util.ControllerUtil.*;

public class AddTripController implements AbstractController {

    private TripDto dto;

    @Qualifier("memberAdd")
    @Autowired
    private ViewHolder memberAddView;

    @Autowired
    private TripService tripService;

    @FXML
    private TextField title;

    @FXML
    private TextArea description;

    @FXML
    private TextField place;

    @FXML
    private DatePicker dateStart;

    @FXML
    private TextField timeStart;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private TextField timeEnd;

    @FXML
    private Spinner<Double> additionalExpenses;

    @FXML
    private ListView<MemberDto> members;

    @Override
    public void onShow() {
        dto = new TripDto();
        dto.setFullMembers(new ArrayList<>());
        title.setText(null);
        description.setText(null);
        dateStart.setValue(getDate(new Date()));
        timeStart.setText(getTime(new Date()));
        dateEnd.setValue(getDate(new Date()));
        timeEnd.setText(getTime(new Date()));
        additionalExpenses.setValueFactory(getSpinnerFactory(0.0));
        members.setItems(null);
    }

    @Override
    public void onClose() {
    }

    public void addMember(ActionEvent event) {
        ControllerUtil.openWindow(memberAddView, (Stage) ((Button) event.getSource()).getScene().getWindow());
    }

    public void addMember(MemberDto member) {
        dto.getFullMembers().add(member);
        members.setItems(FXCollections.observableArrayList(dto.getFullMembers()));
    }

    public void getItem(MouseEvent event) {
        members.getSelectionModel().getSelectedItems();
    }

    public void doApprove(ActionEvent event) {
        dto = new TripDto();
        dto.setTitle(title.getText());
        dto.setDescription(description.getText());
        dto.setPlace(place.getText());
        dto.setStart(toDate(dateStart.getValue(), timeStart.getText()));
        dto.setEnd(toDate(dateEnd.getValue(), timeEnd.getText()));
        dto.setAdditionalExpenses(additionalExpenses.getValue());
        tripService.add(dto);

        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }
}
