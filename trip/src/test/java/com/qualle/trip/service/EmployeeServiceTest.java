package com.qualle.trip.service;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.dto.EmployeeSimpleDto;
import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private final static String NAME = "Test";
    private final static String SURNAME = "Tester";
    private final static String EMAIL = "test@test.ts";
    private final static String DEPARTMENT = "Test";

    @Test
    void toDto() {
        Employee test = getTestEntity(1L);
        EmployeeDto expected = new EmployeeDto(NAME + 1, SURNAME + 1, EMAIL + 1, DEPARTMENT + 1, null);
        expected.setId(1L);
        EmployeeDto actual = new EmployeeServiceImpl().toDto(test);
        assertEquals(expected, actual);
    }

    @Test
    void toSimpleDto() {
        Employee test = getTestEntity(1L);
        EmployeeSimpleDto expected = new EmployeeSimpleDto(NAME + 1, SURNAME + 1, EMAIL + 1);
        expected.setId(1L);
        EmployeeSimpleDto actual = new EmployeeServiceImpl().toSimpleDto(test);
        assertEquals(expected, actual);
    }

    @Test
    void toDtoArray() {
        List<Employee> test = getTestList();
        List<EmployeeDto> expected = new ArrayList<>();
        for (Employee employee : test) {
            EmployeeDto expectedEntity = new EmployeeDto(employee.getName(), employee.getSurname(), employee.getEmail(), employee.getDepartment(), null);
            expectedEntity.setId(employee.getId());
            expected.add(expectedEntity);
        }
        List<EmployeeDto> actual = new EmployeeServiceImpl().toDtoArray(test);
        assertEquals(expected, actual);
    }

    @Test
    void toSimpleDtoArray() {
        List<Employee> test = getTestList();
        List<EmployeeSimpleDto> expected = new ArrayList<>();
        for (Employee employee : test) {
            EmployeeSimpleDto expectedEntity = new EmployeeSimpleDto(employee.getName(), employee.getSurname(), employee.getEmail());
            expectedEntity.setId(employee.getId());
            expected.add(expectedEntity);
        }
        List<EmployeeSimpleDto> actual = new EmployeeServiceImpl().toSimpleDtoArray(test);
        assertEquals(expected, actual);
    }

    private static Employee getTestEntity(long id) {
        Employee test = new Employee(NAME + id, EMAIL + id, SURNAME + id, DEPARTMENT + id, null);
        test.setId(id);
        return test;
    }

    private static List<Employee> getTestList() {
        List<Employee> test = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            test.add(getTestEntity(i));
        }
        return test;
    }
}
