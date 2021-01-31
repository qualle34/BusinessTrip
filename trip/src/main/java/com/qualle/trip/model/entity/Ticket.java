package com.qualle.trip.model.entity;

import com.qualle.trip.model.enums.TicketType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ticket", schema = "public")
public class Ticket {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "\"from\"")
    private String from;

    @Column(name = "\"to\"")
    private String to;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private TicketType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Ticket(String from, String to, Date date, double price, TicketType type) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.price = price;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Double.compare(ticket.price, price) == 0 &&
                Objects.equals(id, ticket.id) &&
                Objects.equals(from, ticket.from) &&
                Objects.equals(to, ticket.to) &&
                Objects.equals(date, ticket.date) &&
                type == ticket.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, date, price, type);
    }
}
