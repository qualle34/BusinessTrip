package com.qualle.trip.service.util;

import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.model.enums.TripStatus;

import java.text.MessageFormat;
import java.util.EnumSet;
import java.util.List;

public class TripsSummaryFormatter {

    public static String format(List<TripSimpleDto> trips) {
        StringBuilder summary = new StringBuilder();

        EnumSet.allOf(TripStatus.class).forEach(
                status -> summary.append(
                        MessageFormat.format(status.getFormatted(),
                                trips.stream().filter(t -> status.equals(t.getStatus())).count()))
        );

        return summary.toString();
    }
}
