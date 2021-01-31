package com.qualle.trip.service.util;

import com.qualle.trip.model.dto.MemberAllowanceDto;
import com.qualle.trip.model.dto.TicketDto;
import lombok.experimental.UtilityClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@UtilityClass
public class ServiceUtil {

    public static String formatDate(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy г.");
        return simpleDateFormat.format(date);
    }

    public static Object getTicketInfo(List<TicketDto> dto) {
        List<String> output = new ArrayList<>();

        for (TicketDto ticket : dto) {
            output.add(ticket.getFrom() + " - " + ticket.getTo() + " " + ticket.getPrice());
        }
        return output;
    }

    public static Object getAllowanceInfo(List<MemberAllowanceDto> dto) {
        List<String> output = new ArrayList<>();

        for (MemberAllowanceDto allowance : dto) {
            String info = allowance.getAllowance().getCountry() + " - " + allowance.getAllowance().getValue() * allowance.getDays() + " " + allowance.getAllowance().getCurrency();
            output.add(info);
        }
        return output;
    }
}