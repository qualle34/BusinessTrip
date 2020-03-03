package com.qualle.trip.controller.edit;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.controller.util.ControllerUtil;
import com.qualle.trip.model.dto.MemberSimpleDto;
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

import static com.qualle.trip.controller.util.ControllerUtil.*;

public class EditTripController implements AbstractController {

    private TripDto dto;
    private long id;

    @Qualifier("memberEdit")
    @Autowired
    private ViewHolder memberEditView;

    @Autowired
    private TripService tripService;

    @FXML
    private TextField title;

    @FXML
    private TextArea description;

    @FXML
    public TextField place;

    @FXML
    private DatePicker dateStart;

    @FXML
    private TextField timeStart;

    @FXML
    private DatePicker dateEnd;

    @FXML
    private TextField timeEnd;

    @FXML
    private TextField status;

    @FXML
    private Spinner<Double> additionalExpenses;

    @FXML
    private TextField expenses;

    @FXML
    private ListView<MemberSimpleDto> members;

    @Override
    public void onShow() {

        if (id != 0) {
            dto = tripService.getFullDtoById(id);
            title.setText(dto.getTitle());
            description.setText(dto.getDescription());
            place.setText(dto.getPlace());
            dateStart.setValue(getDate(dto.getStart()));
            timeStart.setText(getTime(dto.getStart()));
            dateEnd.setValue(getDate(dto.getEnd()));
            timeEnd.setText(getTime(dto.getEnd()));
            status.setText(dto.getStatus());
            additionalExpenses.setValueFactory(getSpinnerFactory(dto.getAdditionalExpenses()));
            System.out.println(dto.getAdditionalExpenses() + " " + additionalExpenses.getValue());
            expenses.setText(String.valueOf(dto.getExpenses()));
            members.setItems(FXCollections.observableArrayList(dto.getMembers()));
        }
    }

    @Override
    public void onClose() {
        id = 0;
        dto = null;
        title.setText(null);
        description.setText(null);
        place.setText(null);
        dateStart.setValue(null);
        timeStart.setText(null);
        dateEnd.setValue(null);
        timeEnd.setText(null);
        status.setText(null);
        additionalExpenses.setValueFactory(null);
        expenses.setText(null);
        members.setItems(null);
    }

    @FXML
    public void getItem(MouseEvent click) {

        if (click.getClickCount() == 2) {
            ((EditMemberController) memberEditView.getController()).setId((members.getSelectionModel().getSelectedItem()).getId());
            ControllerUtil.openWindow(memberEditView, (Stage) ((ListView) click.getSource()).getScene().getWindow());
        }
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (id != 0) {
            dto.setTitle(title.getText());
            dto.setDescription(description.getText());
            dto.setStart(toDate(dateStart.getValue(), timeStart.getText()));
            dto.setEnd(toDate(dateEnd.getValue(), timeEnd.getText()));
            dto.setAdditionalExpenses(additionalExpenses.getValue());
            dto.setMembers(dto.getMembers());
            tripService.update(dto);
        }

        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
