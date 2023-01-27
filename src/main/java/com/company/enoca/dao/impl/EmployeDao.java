package com.company.enoca.dao.impl;

import com.company.enoca.dao.IEmployeeDao;
import com.company.enoca.entities.Employee;
import com.company.enoca.repository.EmployeeRepository;
import org.springframework.stereotype.Repository;

import java.security.InvalidKeyException;
import java.util.List;
import java.util.Optional;

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
        if(!employee.getLastName().isEmpty()) //
            emp.setLastName(employee.getLastName());

      /*
        Optional<Employee> emp=repository.findById(employee.getId());
        //f:alican l:taş
        if(!emp.isEmpty()) {
            if (!employee.getFirstName().isEmpty())
                emp.get().setFirstName(employee.getFirstName());, ;//f:alihan
            if (!employee.getLastName().isEmpty()) //
                emp.get().setLastName(employee.getLastName());
        }
        */

        return repository.save(emp);
    }

    @Override
    public List<Employee> getAll() {

        return repository.findAll();
    }

    @Override
    public void delete(Long id) throws InvalidKeyException {
        try{
        repository.deleteById(id);
        }catch (Exception e){
            throw new InvalidKeyException("Something went wrong");
        }
    }

    @Override
    public Employee getEmployeeById(Long id) throws NullPointerException {
        Optional<Employee > employee=repository.findById(id);
        if (employee.isEmpty()){
            throw new NullPointerException("not employee belongs to id");
        }
        return employee.get();
    }


}
