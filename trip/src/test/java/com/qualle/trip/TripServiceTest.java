package com.qualle.trip;

import com.qualle.trip.service.impl.TripServiceImpl;
import org.junit.jupiter.api.Test;

class TripServiceTest {

    @Test
    void report() {
        new TripServiceImpl().report(2, "");
    }

    @Test
    void toDto() {
    }

    @Test
    void toSimpleDto() {
    }

    @Test
    void toSimpleDtoArray() {
    }
}
