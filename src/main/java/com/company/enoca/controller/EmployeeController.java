package com.company.enoca.controller;

import com.company.enoca.entities.Employee;
import com.company.enoca.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    IEmployeeService employeeService;

    @PostMapping ("create")
    public Employee create(@RequestBody Employee employee){
        return employeeService.create(employee);
    }
    @PutMapping("update")
    public Employee update(@RequestBody Employee employee){
        return employeeService.update(employee);
    }
    @GetMapping("employees")
    public List<Employee> getAll(){
        return employeeService.getAll();
    }
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id)
    {
        employeeService.delete(id);
    }


}
