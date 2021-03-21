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
    private String patronymic;
    private String position;
    private String department;
    private String email;
    private LocalDate birthday;
    private List<TripSimpleDto> trips;
    private List<TicketDto> tickets;

    public EmployeeDto(String name, String surname, String patronymic, String position, String department, String email, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.position = position;
        this.department = department;
        this.email = email;
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
