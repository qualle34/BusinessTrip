package com.qualle.trip.model.entity;

import com.qualle.trip.model.enums.TicketType;

import javax.persistence.*;
import java.util.Date;

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

    public Ticket() {
    }

    public Ticket(String from, String to, Date date, double price, TicketType type) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.price = price;
        this.type = type;
    }

    public Ticket(String from, String to, Date date, double price, TicketType type, Member member) {
        this.from = from;
        this.to = to;
        this.date = date;
        this.price = price;
        this.type = type;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TicketType getType() {
        return type;
    }

    public void setType(TicketType type) {
        this.type = type;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
