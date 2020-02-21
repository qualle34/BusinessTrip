package com.qualle.trip.model.dto;

import java.time.LocalDate;

public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String department;
    private LocalDate birthday;
    private boolean isRelevant;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String surname, String email, String department, LocalDate birthday, boolean isRelevant) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.department = department;
        this.birthday = birthday;
        this.isRelevant = isRelevant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public boolean isRelevant() {
        return isRelevant;
    }

    public void setRelevant(boolean relevant) {
        isRelevant = relevant;
    }
}
