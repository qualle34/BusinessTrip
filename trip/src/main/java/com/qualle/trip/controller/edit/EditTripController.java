package com.qualle.trip.controller.edit;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.controller.AbstractController;
import com.qualle.trip.controller.util.ControllerUtil;
import com.qualle.trip.model.dto.MemberSimpleDto;
import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EditTripController implements AbstractController {

    private TripDto dto;
    private long id;

    @Qualifier("memberEdit")
    @Autowired
    private ControllerConfig.ViewHolder memberEditView;

    @Autowired
    private TripService tripService;

    @FXML
    private TextField title;

    @FXML
    private TextArea description;

    @FXML
    private TextField start;

    @FXML
    private TextField end;

    @FXML
    private TextField status;

    @FXML
    private TextField additionalExpenses;

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
            start.setText(dto.getStart().toString());
            end.setText(dto.getEnd().toString());
            status.setText(dto.getStatus());
            additionalExpenses.setText(String.valueOf(dto.getAdditionalExpenses()));
            expenses.setText(String.valueOf(dto.getExpenses()));
            members.setItems(FXCollections.observableArrayList(dto.getMembers()));

        } else {
            dto = null;
            title.setText(null);
            description.setText(null);
            start.setText(null);
            end.setText(null);
            status.setText(null);
            additionalExpenses.setText(null);
            expenses.setText(null);
            members.setItems(null);
        }
    }

    @FXML
    public void getItem(MouseEvent click) {

        if (click.getClickCount() == 2) {
            ListView listView = (ListView) click.getSource();
            ((EditMemberController) memberEditView.getController()).setId((members.getSelectionModel().getSelectedItem()).getId());
            ControllerUtil.openWindow(memberEditView, (Stage) listView.getScene().getWindow());
        }
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (id != 0) {
            dto.setTitle(title.getText());
            dto.setDescription(description.getText());
//        dto.setStart(start);
//        dto.setEnd(end);
            dto.setAdditionalExpenses(Double.parseDouble(additionalExpenses.getText()));
//        dto.setMembers(dto.getMembers());
            tripService.update(dto);
        }

        ((Stage) ((Button) event.getSource()).getScene().getWindow()).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
