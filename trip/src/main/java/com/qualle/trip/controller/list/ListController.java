package com.qualle.trip.controller.list;

import com.qualle.trip.controller.BaseController;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public interface ListController extends BaseController {

    void add(ActionEvent event);

    void doSearch(KeyEvent event);

    void delete(ActionEvent event);

    void getItem(MouseEvent click);

    void onShow();

    void onClose();

    void doReport(ActionEvent event);

    @Override
    default boolean validate() {
        return true;
    }
}
