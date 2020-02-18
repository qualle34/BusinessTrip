package com.qualle.trip.model.dto;

public class EmployeeDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String department;
    private String birthday;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String surname, String email, String department, String birthday) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.department = department;
        this.birthday = birthday;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
