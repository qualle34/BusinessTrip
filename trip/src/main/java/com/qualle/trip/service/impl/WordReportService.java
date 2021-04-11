package com.qualle.trip.service.impl;

import com.qualle.trip.config.ReportConfig;
import com.qualle.trip.model.dto.MemberDto;
import com.qualle.trip.model.dto.TripDto;
import com.qualle.trip.service.ReportService;
import com.qualle.trip.service.util.WordUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.qualle.trip.service.util.ServiceUtil.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class WordReportService implements ReportService {

    private static final String DELIMITER = "-";

    private final ReportConfig reportConfig;

    @Override
    public void make(TripDto trip) {
        for (MemberDto member : trip.getMembers()) {
            createMemberReport(trip, member);
        }
    }

    private void createMemberReport(TripDto trip, MemberDto member){
        String targetPath = reportConfig.getOutputPath() + getFileName(trip, member);

        WordUtil.createReport(targetPath, reportConfig.getTemplatePath(), getData(trip, member));
    }

    private String getFileName(TripDto trip, MemberDto member) {
        StringBuilder name = new StringBuilder();

        name.append(trip.getTitle())
                .append(DELIMITER)
                .append(member.getEmployee().getSurname())
                .append(DELIMITER)
                .append(member.getEmployee().getName())
                .append(DELIMITER)
                .append(getCurrentDate())
                .append(".docx");

        return name.toString();
    }

    private Map<String, Object> getData(TripDto trip, MemberDto member) {
        Map<String, Object> data = new HashMap<>();
        data.put("date_now", formatDate(new Date()));
        data.put("date_start", formatDate(trip.getStart()));
        data.put("date_end", formatDate(trip.getEnd()));
        data.put("title", trip.getTitle());
        data.put("place", trip.getPlace());
        data.put("description", trip.getDescription());
        data.put("additional_expenses", trip.getAdditionalExpenses() + " р.");
        fillMemberData(data, member);
        return data;
    }

    private void fillMemberData(Map<String, Object> data, MemberDto member) {
        data.put("member", member.getEmployee().getName() + " " + member.getEmployee().getSurname());
        data.put("department", member.getEmployee().getDepartment());
        data.put("allowance_expenses", member.getAllowanceExpenses() + " р.");
        data.put("allowances", getAllowanceInfo(member.getAllowances()));
        data.put("ticket_expenses", member.getTicketsExpenses() + " р.");
        data.put("tickets", getTicketInfo(member.getTickets()));
        data.put("expenses", member.getTicketsExpenses() + member.getAllowanceExpenses() + " р.");
    }

    private String getCurrentDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
