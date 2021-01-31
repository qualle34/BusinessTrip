package com.qualle.trip.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class MemberSimpleDto {

    private long id;
    private String name;
    private String surname;
    private String role;

    public MemberSimpleDto(long id, String name, String surname, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
    }

    @Override
    public String toString() {
        return role + " - " + name + " " + surname;
    }
}
