package com.qualle.trip.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class MemberAllowanceDto {

    private int days;
    private MemberDto member;
    private AllowanceDto allowance;

    public MemberAllowanceDto(AllowanceDto allowance, int days) {
        this.allowance = allowance;
        this.days = days;
    }

    @Override
    public String toString() {
        return allowance.toString() + " - " + days + "д";
    }
}
