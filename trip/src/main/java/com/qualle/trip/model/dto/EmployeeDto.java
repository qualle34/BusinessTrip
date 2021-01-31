package com.qualle.trip.model.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class EmployeeDto {

    private long id;
    private String name;
    private String surname;
    private String email;
    private String department;
    private LocalDate birthday;
    private List<TripSimpleDto> trips;
    private List<TicketDto> tickets;

    public EmployeeDto(String name, String surname, String email, String department, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.department = department;
        this.birthday = birthday;
    }

    public EmployeeDto(EmployeeSimpleDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.surname = dto.getSurname();
        this.email = dto.getEmail();
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
