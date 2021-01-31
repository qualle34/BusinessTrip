package com.qualle.trip.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeSimpleDto {

    private long id;
    private String name;
    private String surname;
    private String email;

    public EmployeeSimpleDto(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
