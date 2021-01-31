package com.qualle.trip.model.enums;

import lombok.Getter;

@Getter
public enum TicketType {

    BUS("Автобус"),
    PLANE("Самолёт"),
    CAR("Машина"),
    TRAIN("Поезд"),
    OTHER("Другое");

    private final String name;

    TicketType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
