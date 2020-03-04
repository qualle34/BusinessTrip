package com.qualle.trip.util;

import com.qualle.trip.controller.util.ControllerUtil;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ControllerUtilTest {

    private final static int YEAR = 2000;
    private final static int MONTH = 2;
    private final static int DATE = 22;
    private final static int HOUR = 22;
    private final static int MINUTE = 22;
    private final static int SECOND = 0;
    private final static int MILLISECOND = 0;

    @Test
    void toDate() {
        Date expected = getTestDate();
        Date actual = ControllerUtil.toDate(LocalDate.of(YEAR, MONTH, DATE), "22:22");
        assertEquals(expected, actual);
    }

    @Test
    void getDate() {
        Date test = getTestDate();
        LocalDate expected = LocalDate.of(YEAR, MONTH, DATE);
        LocalDate actual = ControllerUtil.getDate(test);
        assertEquals(expected, actual);
    }

    @Test
    void getTime() {
        Date test = getTestDate();
        String expected = "22:22";
        String actual = ControllerUtil.getTime(test);
        assertEquals(expected, actual);
    }

    private static Date getTestDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(YEAR, MONTH - 1, DATE, HOUR, MINUTE, SECOND);
        calendar.set(Calendar.MILLISECOND, MILLISECOND);
        return calendar.getTime();
    }
}
