package com.qualle.trip.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToOne
    private Employee employee;

    @ManyToMany(mappedBy = "trips")
    private Set<Ticket> tickets;

    @ManyToMany(mappedBy = "trips")
    private Set<Allowance> Allowances;

    public Trip() {
    }

    public Trip(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Trip(String title, String description, Employee employee, Set<Ticket> tickets, Set<Allowance> allowances) {
        this.title = title;
        this.description = description;
        this.employee = employee;
        this.tickets = tickets;
        Allowances = allowances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Set<Allowance> getAllowances() {
        return Allowances;
    }

    public void setAllowances(Set<Allowance> allowances) {
        Allowances = allowances;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + description;
    }
}
