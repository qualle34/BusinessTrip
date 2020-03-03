package com.qualle.trip.model.entity;

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

    @Column(name="place")
    private String place;

    @Column(name = "date_start")
    @Temporal(TemporalType.TIMESTAMP)
    private Date start;

    @Column(name = "date_end")
    @Temporal(TemporalType.TIMESTAMP)
    private Date end;

    @Column(name = "additional_expenses")
    private double additionalExpenses;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Member> members;

    public Trip() {
    }

    public Trip(String title, String description, String place, double additionalExpenses) {
        this.title = title;
        this.description = description;
        this.place = place;
        this.additionalExpenses = additionalExpenses;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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
}
