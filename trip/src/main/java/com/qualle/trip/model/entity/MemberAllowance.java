package com.qualle.trip.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "member_allowance", schema = "public")
public class MemberAllowance implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "allowance_id")
    private Allowance allowance;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "days")
    private int days;

    public MemberAllowance() {
    }

    public MemberAllowance(Allowance allowance, Member member, int days) {
        this.allowance = allowance;
        this.member = member;
        this.days = days;
    }

    public Allowance getAllowance() {
        return allowance;
    }

    public void setAllowance(Allowance allowance) {
        this.allowance = allowance;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
