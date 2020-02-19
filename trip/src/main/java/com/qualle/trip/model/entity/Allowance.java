package com.qualle.trip.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "allowance", schema = "public")
public class Allowance implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "allowance_id")
    private AllowanceDictionary dictionary;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(name = "days")
    private int days;

    public Allowance() {
    }

    public AllowanceDictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(AllowanceDictionary dictionary) {
        this.dictionary = dictionary;
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

    @Override
    public String toString() {
        return String.valueOf(days);
    }
}
