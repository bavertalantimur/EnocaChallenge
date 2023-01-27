package com.company.enoca.dao;

import com.company.enoca.entities.Employee;

import java.security.InvalidKeyException;
import java.util.List;

public interface IEmployeeDao {
    Employee create(Employee employee);
    Employee update(Employee employee);
    List<Employee> getAll();

    void delete(Long id) throws InvalidKeyException;

    Employee getEmployeeById(Long id) throws NullPointerException;
}
