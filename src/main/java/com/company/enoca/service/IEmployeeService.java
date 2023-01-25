package com.company.enoca.service;

import com.company.enoca.entities.Employee;

import java.util.List;

public interface IEmployeeService {
    Employee create(Employee employee);
    Employee update(Employee employee);
    List<Employee> getAll();
    void delete(Long id);
}
