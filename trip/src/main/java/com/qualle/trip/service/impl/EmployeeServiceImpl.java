package com.qualle.trip.service.impl;

import com.qualle.trip.model.dto.EmployeeDto;
import com.qualle.trip.repository.EmployeeDao;
import com.qualle.trip.service.EmployeeService;
import com.qualle.trip.service.util.ConverterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public EmployeeDto get() {
        return ConverterUtil.toDto(employeeDao.get());
    }
}
