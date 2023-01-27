package com.company.enoca.service;

import com.company.enoca.dto.EmployeeDto;
import com.company.enoca.entities.Employee;

import java.security.InvalidKeyException;
import java.util.List;

public interface IEmployeeService {
    void create(EmployeeDto employee);
    void update(EmployeeDto employee,Long id);
    List<EmployeeDto> getAll();
    void delete(Long id) throws InvalidKeyException;

    EmployeeDto getEmployeeByid(Long id);
}
