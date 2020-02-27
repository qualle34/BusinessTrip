package com.qualle.trip.controller.edit;

import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.service.MemberService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;

public class EditMemberController {

    private long id;

    @Autowired
    private MemberService memberService;

    @FXML
    private TextField employee;

    @FXML
    private TextField allowanceExpenses;

    @FXML
    private TextField ticketsExpenses;

    @FXML
    private TextField trip;

    @FXML
    private ListView<TicketDto> tickets;

    @FXML
    private ListView<MemberAllowanceDto> allowances;

    public void doApprove(ActionEvent event) {
    }

    public void onShow() {
        if (id != 0) {
            MemberDto dto = memberService.getFullDtoById(id);
            employee.setText(dto.getEmployee().toString());
            allowanceExpenses.setText(String.valueOf(dto.getAllowanceExpenses()));
            ticketsExpenses.setText(String.valueOf(dto.getTicketsExpenses()));
            trip.setText(dto.getTrip().getTitle());
            tickets.setItems(FXCollections.observableArrayList(dto.getTickets()));
            allowances.setItems(FXCollections.observableArrayList(dto.getAllowances()));
        }
    }

    public void setId(long id) {
        this.id = id;
    }
}
