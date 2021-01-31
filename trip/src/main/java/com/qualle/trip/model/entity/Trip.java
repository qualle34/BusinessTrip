package com.qualle.trip.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
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

    public Trip(String title, String description, String place, double additionalExpenses) {
        this.title = title;
        this.description = description;
        this.place = place;
        this.additionalExpenses = additionalExpenses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return Double.compare(trip.additionalExpenses, additionalExpenses) == 0 &&
                Objects.equals(id, trip.id) &&
                Objects.equals(title, trip.title) &&
                Objects.equals(description, trip.description) &&
                Objects.equals(place, trip.place) &&
                Objects.equals(start, trip.start) &&
                Objects.equals(end, trip.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, place, start, end, additionalExpenses);
    }
}
