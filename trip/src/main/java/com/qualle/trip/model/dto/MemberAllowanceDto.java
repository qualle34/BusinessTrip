package com.qualle.trip.model.dto;

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
    public String toString() {
        return allowance.toString() + " - " + days + "д";
    }
}
