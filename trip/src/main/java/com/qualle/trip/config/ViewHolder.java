package com.qualle.trip.config;

import com.qualle.trip.controller.AbstractController;
import javafx.scene.Parent;

public class ViewHolder {

    private Parent view;
    private AbstractController controller;

    public ViewHolder(Parent view, AbstractController controller) {
        this.view = view;
        this.controller = controller;
    }

    public Parent getView() {
        return view;
    }

    public void setView(Parent view) {
        this.view = view;
    }

    public AbstractController getController() {
        return controller;
    }

    public void setController(AbstractController controller) {
        this.controller = controller;
    }
}

