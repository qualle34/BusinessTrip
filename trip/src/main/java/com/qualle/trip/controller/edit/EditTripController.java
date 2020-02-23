package com.qualle.trip.controller.edit;

import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.service.MemberService;
import com.qualle.trip.service.TripService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class EditTripController {

    private long id;

    @Autowired
    private TripService tripService;

    @Autowired
    private MemberService memberService;

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
    private ListView<MemberDto> members;


    public void doApprove(ActionEvent event) {
    }

    public void onShow() {
        if (id != 0) {
            TripDto dto = tripService.getDtoById(id);
            title.setText(dto.getTitle());
            description.setText(dto.getDescription());
            start.setText(dto.getStart().toString());
            end.setText(dto.getEnd().toString());
            additionalExpenses.setText(String.valueOf(dto.getExpenses()));
            members.setItems(FXCollections.observableArrayList(memberService.getDtoById(1)));
        }
    }

    public void setId(long id) {
        this.id = id;
    }
}
