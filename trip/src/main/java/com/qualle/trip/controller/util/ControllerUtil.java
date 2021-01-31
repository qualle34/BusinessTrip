package com.qualle.trip.controller.util;

import com.qualle.trip.config.ViewHolder;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

public class ControllerUtil {

    public static void openWindow(ViewHolder viewHolder, Stage owner) {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> viewHolder.getController().onShow());
        stage.setOnCloseRequest(event -> viewHolder.getController().onClose());

        setScene(stage, viewHolder);

        stage.initOwner(owner);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
    }

    public static void openModal(Stage owner, String description) {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.initStyle(StageStyle.UNDECORATED);
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane, 380, 180, Color.WHITE);

        Label title = new Label("Что то пошло не так..");
        title.setAlignment(Pos.CENTER);
        title.setPrefSize(380, 30);
        title.setFont(Font.font(18.0));
        title.setLayoutY(45);
        title.setTextFill(Paint.valueOf("333333"));

        Label desc = new Label(description != null ? description : "Проверьте корректность введённых данных");
        desc.setAlignment(Pos.CENTER);
        desc.setPrefSize(380, 30);
        desc.setFont(Font.font(14.0));
        desc.setLayoutY(90);
        desc.setTextFill(Paint.valueOf("333333"));

        Button approve = new Button("OK");
        approve.setPrefSize(100, 20);
        approve.setLayoutX(140);
        approve.setLayoutY(125);
        approve.setTextFill(Paint.valueOf("333333"));
        approve.setOnAction(event -> stage.close());

        pane.getChildren().add(title);
        pane.getChildren().add(desc);
        pane.getChildren().add(approve);
        stage.setScene(scene);
        stage.show();
    }

    public static void openModal(Stage owner) {
        openModal(owner, null);
    }

    public static void setScene(Stage stage, ViewHolder viewHolder) {

        if (viewHolder.getView().getScene() != null) {
            stage.setScene(viewHolder.getView().getScene());

        } else {
            stage.setScene(new Scene(viewHolder.getView()));
        }
    }

    public static Stage getStage(ActionEvent event) {
        return (Stage) ((Button) event.getSource()).getScene().getWindow();
    }

    public static Stage getStage(MouseEvent event) {
        return (Stage) ((ListView) event.getSource()).getScene().getWindow();
    }

    public static Date toDate(LocalDate date, String time) {
        int[] timeArray = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), timeArray[0], timeArray[1]);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static LocalDate getDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String getTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return MessageFormat.format("{0}:{1}", c.get(Calendar.HOUR_OF_DAY), c.get(Calendar.MINUTE));
    }

    public static SpinnerValueFactory.DoubleSpinnerValueFactory getSpinnerFactory(double initialValue) {
        return new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10000, initialValue);
    }

    public static SpinnerValueFactory.IntegerSpinnerValueFactory getSpinnerFactory(int initialValue) {
        return new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, initialValue);
    }

    public static boolean validateTime(String time) {
        return time.matches("\\d{1,2}[:]\\d{1,2}");
    }
}
