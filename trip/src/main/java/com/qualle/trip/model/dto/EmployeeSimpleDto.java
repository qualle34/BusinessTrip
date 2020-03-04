package com.qualle.trip.model.dto;

import java.util.Objects;

public class EmployeeSimpleDto {

    private long id;
    private String name;
    private String surname;
    private String email;

    public EmployeeSimpleDto() {
    }

    public EmployeeSimpleDto(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeSimpleDto that = (EmployeeSimpleDto) o;
        return id == that.id &&
                name.equals(that.name) &&
                Objects.equals(surname, that.surname) &&
                email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email);
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
