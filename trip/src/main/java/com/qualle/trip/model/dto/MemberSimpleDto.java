package com.qualle.trip.model.dto;

public class MemberSimpleDto {

    private long id;
    private String name;
    private String surname;
    private String role;

    public MemberSimpleDto() {
    }

    public MemberSimpleDto(long id, String name, String surname, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
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

    @Override
    public String toString() {
        return role + " - " + name + " " + surname;
    }
}
