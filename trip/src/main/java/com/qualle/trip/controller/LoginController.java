package com.qualle.trip.controller;

import com.qualle.trip.config.ControllerConfig;
import com.qualle.trip.model.dto.UserDto;
import com.qualle.trip.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;

public class LoginController {

    @Autowired
    private UserService userService;

    @Qualifier("mainView")
    @Autowired
    private ControllerConfig.ViewHolder mainView;

    @FXML
    private TextField login;

    @FXML
    private TextField password;

    @FXML
    public void initialize() {
    }

    @PostConstruct
    public void init() {
    }

    @FXML
    public void doLogin(ActionEvent actionEvent) {
        String login = this.login.getText();
        String password = this.password.getText();

        if (StringUtils.isEmpty(login) || StringUtils.isEmpty(password)) {
            return;
        }
        UserDto user = userService.getDtoByLogin(login);
        if (user == null) {
            return;
        }
        if (!user.getPassword().equals(password)) {
            return;
        }

        Stage dialogStage = new Stage();
        dialogStage.setTitle("Business Trip");
        dialogStage.setScene(new Scene(mainView.getView()));
        dialogStage.show();
    }
}
