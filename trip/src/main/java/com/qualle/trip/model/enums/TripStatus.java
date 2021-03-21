package com.qualle.trip.model.enums;

import lombok.Getter;

@Getter
public enum TripStatus {

    COMPLETED("Завершено", "Завершенные: {0}\n"),
    IN_PROGRESS("В процессе", "Текущие: {0}\n"),
    FUTURE("Скоро", "Запланированные: {0}\n"),
    DEFAULT("Не указано", "Остальные: {0}\n");

    private final String name;
    private final String formatted;

    TripStatus(String name, String formatted) {
        this.name = name;
        this.formatted = formatted;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
