package com.company.enoca.service.impl;

import com.company.enoca.dao.IEmployeeDao;
import com.company.enoca.entities.Employee;
import com.company.enoca.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeDao employeeDao;
    @Override
    public Employee create(Employee employee) {
        return employeeDao.create(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }


}
