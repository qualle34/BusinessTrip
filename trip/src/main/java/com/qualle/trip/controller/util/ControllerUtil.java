package com.qualle.trip.controller.util;

import com.qualle.trip.config.ControllerConfig;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ControllerUtil {

    public static void openWindow(ControllerConfig.ViewHolder viewHolder, Stage owner) {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.addEventHandler(WindowEvent.WINDOW_SHOWN, window -> viewHolder.getController().onShow());

        setScene(stage, viewHolder);

        stage.initOwner(owner);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.showAndWait();
    }

    public static void setScene(Stage stage, ControllerConfig.ViewHolder viewHolder) {
        if (viewHolder.getView().getScene() != null) {
            stage.setScene(viewHolder.getView().getScene());
        } else {
            stage.setScene(new Scene(viewHolder.getView()));
        }
    }
}
