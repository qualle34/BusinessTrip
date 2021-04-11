package com.qualle.trip.util;

import com.qualle.trip.Application;
import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.enums.TicketType;
import com.qualle.trip.service.util.WordUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.net.URLDecoder;
import java.util.*;

import static com.qualle.trip.service.util.ServiceUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@Disabled
public class ReportServiceTest {

    private static final String BASE_PATH = "/S:/University/12/YP/BusinessTrip/";
    private static final String FOLDER = "BusinessTrip";
    private static final String TEMPLATE_PATH = "report/template/report.docx";
    private static final String OUTPUT_PATH = "report/";

    @Test
    void report() {
        Map<String, Object> data = new HashMap<>();

        data.put("date_now", formatDate(new Date()));
        data.put("date_start", formatDate(new Date()));
        data.put("date_end", formatDate(new Date()));
        data.put("member", "Тестов" + " " + "Николай");
        data.put("department", "Отдел продаж");
        data.put("title", "Закупка материалов");
        data.put("place", "Магазин автозапчастей ООО\"Зелёный жигуль\"");
        data.put("description", "По поручению Микашова В.С. необходимо было купить колесо для служебного автомобиля.");
        data.put("allowance_expenses", 20 + " р.");
        data.put("allowances", getAllowanceInfo(Collections.singletonList(new MemberAllowanceDto(new AllowanceDto("Беларусь", 10), 2))));

        data.put("ticket_expenses", 210 + " р.");
        data.put("tickets", getTicketInfo(Arrays.asList(new TicketDto("Гродно", "Минск", new Date(), 110, TicketType.CAR), new TicketDto("Минск", "Гродно", new Date(), 100, TicketType.CAR))));

        data.put("additional_expenses", 120 + "р.");
        data.put("expenses", 230 + "р.");

        WordUtil.createReport(getBasePath() + OUTPUT_PATH + "name.docx", getBasePath() + TEMPLATE_PATH, data);
    }

    @Test
    void testWhenPathIsCorrectThanSuccess() {
        assertEquals(BASE_PATH, getBasePath());
    }

    private String getBasePath() {
        String path = null;

        try {
            path = Application.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            path = URLDecoder.decode(path, "utf-8");
            path = path.substring(0, path.indexOf(FOLDER) + FOLDER.length());
            return path + "/";

        } catch (Exception e) {
            log.warn("Unable to get path ({}): {}", path, e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}