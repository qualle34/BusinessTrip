package com.qualle.trip.service.util;

import com.qualle.trip.model.dto.TripSimpleDto;
import com.qualle.trip.model.enums.TripStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TripsSummaryFormatterTest {

    @Test
    void format() {
        List<TripSimpleDto> trips = new ArrayList<>();
        trips.add(new TripSimpleDto("1", "1", 1, TripStatus.COMPLETED));
        trips.add(new TripSimpleDto("1", "1", 1, TripStatus.COMPLETED));
        trips.add(new TripSimpleDto("1", "1", 1, TripStatus.COMPLETED));
        trips.add(new TripSimpleDto("1", "1", 1, TripStatus.FUTURE));
        trips.add(new TripSimpleDto("1", "1", 1, TripStatus.FUTURE));
        trips.add(new TripSimpleDto("1", "1", 1, TripStatus.IN_PROGRESS));
        trips.add(new TripSimpleDto("1", "1", 1, TripStatus.IN_PROGRESS));

        System.out.println(TripsSummaryFormatter.format(trips));
    }
}