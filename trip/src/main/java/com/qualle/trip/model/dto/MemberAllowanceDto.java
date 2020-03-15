package com.qualle.trip.model.dto;

import java.util.Objects;

public class MemberAllowanceDto {

    private int days;
    private MemberDto member;
    private AllowanceDto allowance;

    public MemberAllowanceDto() {
    }

    public MemberAllowanceDto(AllowanceDto allowance, int days) {
        this.allowance = allowance;
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public MemberDto getMember() {
        return member;
    }

    public void setMember(MemberDto member) {
        this.member = member;
    }

    public AllowanceDto getAllowance() {
        return allowance;
    }

    public void setAllowance(AllowanceDto allowance) {
        this.allowance = allowance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAllowanceDto that = (MemberAllowanceDto) o;
        return days == that.days &&
                Objects.equals(member, that.member) &&
                Objects.equals(allowance, that.allowance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(days, member, allowance);
    }

    @Override
    public String toString() {
        return allowance.toString() + " - " + days + "д";
    }
}
