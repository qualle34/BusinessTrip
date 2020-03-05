package com.qualle.trip.controller;

public interface AbstractController {

    void onShow();

    void onClose();

    boolean validate();
}
