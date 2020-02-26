package com.qualle.trip.model.enums;

public enum TripStatus {

    COMPLETED,
    IN_PROGRESS,
    FUTURE;

    @Override
    public String toString() {
        switch (this) {
            case COMPLETED:
                return "Завершено";
            case IN_PROGRESS:
                return "В процессе";
            case FUTURE:
                return "Скоро";
            default:
                return "Не указано";
        }
    }
}
