package com.qualle.trip.controller.edit;

import com.qualle.trip.controller.BaseController;
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

import static com.qualle.trip.controller.util.ControllerUtil.getStage;

public class EditMemberController implements BaseController {

    private MemberDto dto;
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

    @Override
    public void onShow() {

        if (id != 0) {
            dto = memberService.getDtoById(id);
            employee.setText(dto.getEmployee().toString());
            allowanceExpenses.setText(String.valueOf(dto.getAllowanceExpenses()));
            ticketsExpenses.setText(String.valueOf(dto.getTicketsExpenses()));
            trip.setText(dto.getTrip().getTitle());
            tickets.setItems(FXCollections.observableArrayList(dto.getTickets()));
            allowances.setItems(FXCollections.observableArrayList(dto.getAllowances()));
        }
    }

    @Override
    public void onClose() {
        id = 0;
        dto = null;
        employee.setText(null);
        allowanceExpenses.setText(null);
        ticketsExpenses.setText(null);
        trip.setText(null);
        tickets.setItems(null);
        allowances.setItems(null);
    }

    @Override
    public boolean validate() {
        return true;
    }

    @FXML
    public void doApprove(ActionEvent event) {

        if (id != 0) {
            dto.setTickets(tickets.getItems());
            dto.setAllowances(allowances.getItems());
            memberService.update(dto);
        }

        onClose();
        getStage(event).close();
    }

    public void setId(long id) {
        this.id = id;
    }
}
