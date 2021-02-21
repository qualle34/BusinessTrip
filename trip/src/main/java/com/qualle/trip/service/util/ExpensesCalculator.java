package com.qualle.trip.service.util;

import com.qualle.trip.model.entity.Member;
import com.qualle.trip.model.entity.MemberAllowance;
import com.qualle.trip.model.entity.Ticket;
import lombok.experimental.UtilityClass;

import java.util.Collection;

@UtilityClass
public class ExpensesCalculator {

    public static double calcTicketExpenses(Collection<Member> members) {
        return members.stream().mapToDouble(ExpensesCalculator::calcTicketExpensesForMember).sum();
    }

    public static double calcAllowanceExpenses(Collection<Member> members) {
        return members.stream().mapToDouble(ExpensesCalculator::calcAllowanceExpensesForMember).sum();
    }

    private static double calcTicketExpensesForMember(Member member) {
        return member.getTickets().stream().mapToDouble(Ticket::getPrice).sum();
    }

    private static double calcAllowanceExpensesForMember(Member member) {
        int allDays = member.getMemberAllowances().stream().mapToInt(MemberAllowance::getDays).sum();
        double maxDayPrice = member.getMemberAllowances().stream().mapToDouble(ma -> ma.getAllowance().getValue()).max().orElse(0);

        return allDays * maxDayPrice;
    }
}
