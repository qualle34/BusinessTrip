package com.qualle.trip.util;

import com.qualle.trip.model.dto.AllowanceDto;
import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.dto.TicketDto;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.model.enums.TicketType;
import com.qualle.trip.service.util.WordUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.qualle.trip.service.util.ServiceUtil.*;

class WordUtilTest {

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
        data.put("allowances", getAllowanceInfo(Collections.singletonList(new MemberAllowanceDto(new AllowanceDto("Беларусь", 10, "р."), 2))));

        data.put("ticket_expenses", 210 + " р.");
        data.put("tickets", getTicketInfo(Arrays.asList(new TicketDto("Гродно", "Минск", new Date(), 110, TicketType.CAR), new TicketDto("Минск", "Гродно", new Date(), 100, TicketType.CAR))));

        data.put("additional_expenses", 120 + "р.");
        data.put("expenses", 230 + "р.");

        WordUtil.createReport("", "1", data);
    }
}