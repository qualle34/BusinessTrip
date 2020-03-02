package com.qualle.trip.controller.util;

import com.qualle.trip.config.ViewHolder;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.time.Instant;
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

    public static void setScene(Stage stage, ViewHolder viewHolder) {
        if (viewHolder.getView().getScene() != null) {
            stage.setScene(viewHolder.getView().getScene());
        } else {
            stage.setScene(new Scene(viewHolder.getView()));
        }
    }

    public static Date toDate(LocalDate date, String time) {
        int[] timeArray = Stream.of(time.split(":")).mapToInt(Integer::parseInt).toArray();
        Calendar calendar = Calendar.getInstance();
        calendar.set(date.getYear(), date.getMonthValue() - 1, date.getDayOfMonth(), timeArray[0], timeArray[1], 0);
        return calendar.getTime();
    }

    public static LocalDate getDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String getTime(Date date) {
        return date.getHours() + ":" + date.getMinutes();
    }

    public static SpinnerValueFactory.DoubleSpinnerValueFactory getSpinnerFactory(double initialValue) {
       return new SpinnerValueFactory.DoubleSpinnerValueFactory(0, 10000, initialValue);
    }

    public static SpinnerValueFactory.IntegerSpinnerValueFactory getSpinnerFactory(int initialValue) {
        return new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10000, initialValue);
    }
}
