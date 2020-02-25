package com.qualle.trip.controller.edit;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.model.dto.*;
import com.qualle.trip.service.MemberService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EditTripController {

    private long id;

    @Qualifier("memberEditView")
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
    private ListView<MemberDto> members;

    public void doApprove(ActionEvent event) {
    }

    public void onShow() {
        if (id != 0) {
            TripFullDto dto = tripService.getFullDtoById(id);
            title.setText(dto.getTitle());
            description.setText(dto.getDescription());
            start.setText(dto.getStart().toString());
            end.setText(dto.getEnd().toString());
            status.setText(dto.getStatus());
            additionalExpenses.setText(String.valueOf(dto.getAdditionalExpenses()));
            expenses.setText(String.valueOf(dto.getExpenses()));
            members.setItems(FXCollections.observableArrayList(dto.getMembers()));
        }
    }

    @FXML
    public void getItem(MouseEvent click) {

        if (click.getClickCount() == 2) {
            ListView listView = (ListView) click.getSource();
            Stage dialog = new Stage();
            dialog.setResizable(false);

            EditMemberController editMemberController = (EditMemberController) memberEditView.getController();
            editMemberController.setId((members.getSelectionModel().getSelectedItem()).getId());
            dialog.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> editMemberController.onShow());

            setScene(dialog, memberEditView);

            dialog.initOwner(listView.getScene().getWindow());
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.showAndWait();
        }
    }

    private void setScene(Stage dialog, ControllerConfig.ViewHolder viewHolder) {
        if (viewHolder.getView().getScene() != null) {
            dialog.setScene(viewHolder.getView().getScene());
        } else {
            dialog.setScene(new Scene(viewHolder.getView()));
        }
    }

    public void setId(long id) {
        this.id = id;
    }
}
