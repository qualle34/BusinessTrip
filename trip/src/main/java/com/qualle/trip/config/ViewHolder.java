package com.qualle.trip.config;

import com.qualle.trip.controller.BaseController;
import javafx.scene.Parent;

public class ViewHolder {

    private Parent view;
    private BaseController controller;

    public ViewHolder(Parent view, BaseController controller) {
        this.view = view;
        this.controller = controller;
    }

    public Parent getView() {
        return view;
    }

    public void setView(Parent view) {
        this.view = view;
    }

    public BaseController getController() {
        return controller;
    }

    public void setController(BaseController controller) {
        this.controller = controller;
    }
}

