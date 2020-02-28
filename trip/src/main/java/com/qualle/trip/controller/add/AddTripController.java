package com.qualle.trip.controller.add;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

public class AddTripController implements AbstractController  {

    private TripDto dto;

    @Qualifier("memberAdd")
    @Autowired
    private ControllerConfig.ViewHolder memberAddView;

    @Autowired
    private TripService tripService;

    @FXML
    public TextField title;

    @FXML
    public TextArea description;

    @FXML
    public TextField place;

    @FXML
    public DatePicker start;

    @FXML
    public DatePicker end;

    @FXML
    public TextField additionalExpenses;

    @FXML
    public ListView<MemberDto> members;

    @PostConstruct
    public void init() {
        dto = new TripDto();
        dto.setFullMembers(new ArrayList<>());
    }

    public void getItem(MouseEvent event) {
    }

    public void doApprove(ActionEvent event) {
        tripService.add(dto);
        reset();
        Button button = (Button) event.getSource();
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    public void addMember(ActionEvent event) {
        Button button = (Button) event.getSource();
        Stage dialog = new Stage();

        if (memberAddView.getView().getScene() != null) {
            dialog.setScene(memberAddView.getView().getScene());
        } else {
            dialog.setScene(new Scene(memberAddView.getView()));
        }

        dialog.initOwner(button.getScene().getWindow());
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.showAndWait();
    }

    public void addMember(MemberDto member) {
        dto.getFullMembers().add(member);
        refresh();
    }

    private void refresh() {
        members.setItems(FXCollections.observableArrayList(dto.getFullMembers()));
    }

    private void reset() {
        dto = null;
        title.setText(null);
        description.setText(null);
        place.setText(null);
        start.setValue(null);
        end.setValue(null);
        additionalExpenses.setText(null);
        members.setItems(null);
    }

    @Override
    public void onShow() {

    }
}
