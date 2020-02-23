package com.qualle.trip.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "allowance", schema = "public")
public class Allowance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allowance_seq")
    @SequenceGenerator(name = "allowance_dictionary_seq", sequenceName = "allowance_dictionary_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "value")
    private double value;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "dictionary")
    private Set<MemberAllowance> memberAllowances;

    public Allowance() {
    }

    public Allowance(double value, String country) {
        this.value = value;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<MemberAllowance> getMemberAllowances() {
        return memberAllowances;
    }

    public void setMemberAllowances(Set<MemberAllowance> memberAllowances) {
        this.memberAllowances = memberAllowances;
    }

    @Override
    public String toString() {
        return id + " " + value + " " + country;
    }
}
