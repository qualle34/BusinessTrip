package com.qualle.trip.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "allowance_dictionary", schema = "public")
public class AllowanceDictionary {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allowance_dictionary_seq")
    @SequenceGenerator(name = "allowance_dictionary_seq", sequenceName = "allowance_dictionary_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "value")
    private double value;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "dictionary")
    private Set<Allowance> allowances;

    public AllowanceDictionary() {
    }

    public AllowanceDictionary(double value, String country) {
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

    public Set<Allowance> getAllowances() {
        return allowances;
    }

    public void setAllowances(Set<Allowance> allowances) {
        this.allowances = allowances;
    }

    @Override
    public String toString() {
        return id + " " + value + " " + country;
    }
}
