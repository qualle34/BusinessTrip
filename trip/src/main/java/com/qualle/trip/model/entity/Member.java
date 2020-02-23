package com.qualle.trip.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "member", schema = "public")
public class Member {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_seq")
    @SequenceGenerator(name = "trip_seq", sequenceName = "trip_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @OneToMany(mappedBy = "member")
    private Set<MemberAllowance> memberAllowances;

    @OneToMany(mappedBy = "member")
    private Set<Ticket> tickets;

    @Column(name="role")
    private String role;

    public Member() {
    }

    public Member(Employee employee, Trip trip, Set<MemberAllowance> memberAllowances, Set<Ticket> tickets, String role) {
        this.employee = employee;
        this.trip = trip;
        this.memberAllowances = memberAllowances;
        this.tickets = tickets;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Set<MemberAllowance> getMemberAllowances() {
        return memberAllowances;
    }

    public void setMemberAllowances(Set<MemberAllowance> memberAllowances) {
        this.memberAllowances = memberAllowances;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
