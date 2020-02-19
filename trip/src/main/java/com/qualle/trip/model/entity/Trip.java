package com.qualle.trip.model.entity;

import com.qualle.trip.model.enums.TripStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "trip", schema = "public")
public class Trip {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "trip_seq")
    @SequenceGenerator(name = "trip_seq", sequenceName = "trip_id_seq", allocationSize = 1)
    private Long id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name = "date_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "date_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private TripStatus status;

    @Column(name = "additional_expenses")
    private double additionalExpenses;

    @OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)
    private Set<Member> members;

    public Trip() {
    }

    public Trip(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Trip(Long id, Date start, Date end, TripStatus status, Set<Member> members) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.status = status;
        this.members = members;
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

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public double getAdditionalExpenses() {
        return additionalExpenses;
    }

    public void setAdditionalExpenses(double additionalExpenses) {
        this.additionalExpenses = additionalExpenses;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + description;
    }
}
