package com.qualle.trip.controller.edit;

import com.qualle.trip.config.ViewHolder;
import com.qualle.trip.controller.BaseController;
import com.qualle.trip.controller.add.AddMemberController;
import com.qualle.trip.controller.list.TripListController;
import com.qualle.trip.controller.util.ControllerUtil;
import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.service.MemberService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static com.qualle.trip.controller.util.ControllerUtil.*;

public class EditTripController implements BaseController {

    private TripDto dto;
    private long id;

    @Autowired
    private ViewHolder memberEditView;

    @Autowired
    private ViewHolder memberAddView;

    @Autowired
    private TripListController tripListController;

    @Autowired
    private TripService tripService;

    @Autowired
    private MemberService memberService;

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
    private TextField additionalExpenses;

    @FXML
    private TextField expenses;

    @FXML
    private ListView<MemberDto> members;

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
            status.setText(dto.getStatus().toString());
            additionalExpenses.setText(String.valueOf(dto.getAdditionalExpenses()));
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
        dateStart.setValue(getDate(new Date()));
        timeStart.setText(getTime(new Date()));
        dateEnd.setValue(getDate(new Date()));
        timeEnd.setText(getTime(new Date()));
        status.setText(null);
        additionalExpenses.setText(null);
        expenses.setText(null);
        members.setItems(null);
        tripListController.onShow();
    }

    @Override
    public boolean validate() {
        return !title.getText().isEmpty() && !place.getText().isEmpty() && validateTime(timeStart.getText()) && validateTime(timeEnd.getText());
    }

    @FXML
    public void getItem(MouseEvent click) {

        if (click.getClickCount() == 2) {
            ((EditMemberController) memberEditView.getController()).setId((members.getSelectionModel().getSelectedItem()).getId());
            ControllerUtil.openWindow(memberEditView, (Stage) ((ListView) click.getSource()).getScene().getWindow());
        }
    }

    @FXML
    public void addMember(ActionEvent event) {
        AddMemberController controller = (AddMemberController) memberAddView.getController();
        controller.setTripId(id);
        openWindow(memberAddView, getStage(event));
    }

    @FXML
    public void deleteMember(ActionEvent event) {
        long memberId = members.getSelectionModel().getSelectedItem().getId();
        memberService.delete(memberId);
        dto.getMembers().removeIf(m -> m.getId() == memberId);
        members.setItems(FXCollections.observableArrayList(dto.getMembers()));
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (!validate()) {
            openModal(getStage(event));
            return;
        }

        if (id != 0) {
            dto.setTitle(title.getText());
            dto.setDescription(description.getText());
            dto.setStart(toDate(dateStart.getValue(), timeStart.getText()));
            dto.setEnd(toDate(dateEnd.getValue(), timeEnd.getText()));
            dto.setAdditionalExpenses(Double.parseDouble(additionalExpenses.getText()));
            dto.setMembers(dto.getMembers());
            tripService.update(dto);
        }

        onClose();
        getStage(event).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
