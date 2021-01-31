package com.qualle.trip.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
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

    public MemberAllowance(Allowance allowance, Member member, int days) {
        this.allowance = allowance;
        this.member = member;
        this.days = days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberAllowance that = (MemberAllowance) o;
        return days == that.days &&
                Objects.equals(allowance, that.allowance) &&
                Objects.equals(member, that.member);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowance, member, days);
    }
}
