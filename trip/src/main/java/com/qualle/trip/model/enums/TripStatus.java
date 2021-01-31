package com.qualle.trip.model.enums;

import lombok.Getter;

@Getter
public enum TripStatus {

    COMPLETED("Завершено"),
    IN_PROGRESS("В процессе"),
    FUTURE("Скоро"),
    DEFAULT("Не указано");

    private final String name;

    TripStatus(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
