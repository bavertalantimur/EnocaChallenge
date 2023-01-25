package com.company.enoca.dao.impl;

import com.company.enoca.dao.IEmployeeDao;
import com.company.enoca.entities.Employee;
import com.company.enoca.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeDao implements IEmployeeDao {
    EmployeeRepository repository;

    EmployeDao(EmployeeRepository repository){
        this.repository=repository;
    }
    @Override
    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    @Override//f:alihan  l:kaş
    public Employee update(Employee employee) {
        Employee emp=repository.findById(employee.getId()).orElse(null);
        //f:alican l:taş
        if(!employee.getFirstName().isEmpty())
            emp.setFirstName(employee.getFirstName());//f:alihan
        if(!employee.getLastName().isEmpty()) //l:kaş
            emp.setLastName(employee.getLastName());

        return repository.save(emp);
    }

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }


}
