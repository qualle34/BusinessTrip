package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.model.entity.Employee;
import com.qualle.trip.repository.EmployeeDao;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<EmployeeDto> getDto() {
        return ConverterUtil.toEmployeeDtoArray(employeeDao.get());
    }

    @Override
    public List<EmployeeDto> getDtoSortByTrip() {
        return ConverterUtil.toEmployeeDtoArray(employeeDao.getSortByTrip());
    }

    @Override
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Employee employee : employeeDao.getSortByTrip()){
            names.add(employee.getName() + " " + employee.getSurname());
        }
        return names;
    }

    @Override
    public Employee get(long id) {
        return employeeDao.get(id);
    }

    @Override
    public EmployeeDto getDto(long id) {
        return ConverterUtil.toEmployeeDto(employeeDao.get(id));
    }
}
