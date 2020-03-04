package com.qualle.trip.model.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class EmployeeDto {

    private long id;
    private String name;
    private String surname;
    private String email;
    private String department;
    private LocalDate birthday;
    private List<TripSimpleDto> trips;
    private List<TicketDto> tickets;

    public EmployeeDto() {
    }

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<TripSimpleDto> getTrips() {
        return trips;
    }

    public void setTrips(List<TripSimpleDto> trips) {
        this.trips = trips;
    }

    public List<TicketDto> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDto> tickets) {
        this.tickets = tickets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto dto = (EmployeeDto) o;
        return Objects.equals(id, dto.id) &&
                name.equals(dto.name) &&
                Objects.equals(surname, dto.surname) &&
                email.equals(dto.email) &&
                Objects.equals(department, dto.department) &&
                Objects.equals(birthday, dto.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, department, birthday);
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
