package com.qualle.trip.model.enums;

public enum  TicketType {

    BUS,
    PLANE,
    CAR,
    TRAIN,
    OTHER;

    @Override
    public String toString() {
        switch(this) {
            case BUS: return "Автобус";
            case PLANE: return "Самолёт";
            case CAR: return "Машина";
            case TRAIN: return "Поезд";
            default: return "Другое";
        }
    }
}
