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
@Table(name = "allowance", schema = "public")
public class Allowance {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "allowance_seq")
    @SequenceGenerator(name = "allowance_seq", sequenceName = "allowance_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "value")
    private double value;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "allowance", cascade = CascadeType.ALL)
    private Set<MemberAllowance> memberAllowances;

    public Allowance(double value, String country) {
        this.value = value;
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allowance allowance = (Allowance) o;
        return Double.compare(allowance.value, value) == 0 &&
                Objects.equals(id, allowance.id) &&
                Objects.equals(country, allowance.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value, country);
    }
}
