package com.qualle.trip.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "member", schema = "public")
public class Member {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq")
    @SequenceGenerator(name = "member_seq", sequenceName = "member_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MemberAllowance> memberAllowances;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

    @Column(name="role")
    private String role;

    public Member(Employee employee, Trip trip, Set<MemberAllowance> memberAllowances, Set<Ticket> tickets, String role) {
        this.employee = employee;
        this.trip = trip;
        this.memberAllowances = memberAllowances;
        this.tickets = tickets;
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) &&
                Objects.equals(employee, member.employee) &&
                Objects.equals(trip, member.trip) &&
                Objects.equals(role, member.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employee, trip, role);
    }
}
