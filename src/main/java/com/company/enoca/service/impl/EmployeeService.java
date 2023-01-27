package com.company.enoca.service.impl;

import com.company.enoca.dao.IEmployeeDao;
import com.company.enoca.dto.EmployeeDto;
import com.company.enoca.entities.Employee;
import com.company.enoca.repository.EmployeeRepository;
import com.company.enoca.service.IEmployeeService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Data
public class EmployeeService implements IEmployeeService {
    @Autowired
    IEmployeeDao employeeDao;
    private ModelMapper modelMapper;

    public EmployeeService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        employeeDao.create(employee);

    }

    @Override
    public void update(EmployeeDto employeeDto,Long id) {
        Employee employee1=modelMapper.map(employeeDto,Employee.class);
        employee1.setId(id);
        employeeDao.update(employee1);
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeDto> employeeDtos=new ArrayList<>();
        employeeDao.getAll().forEach(employee->employeeDtos.add(modelMapper.map(employee,EmployeeDto.class)));
       return employeeDtos;
    }
    @Override
    public void delete(Long id) throws InvalidKeyException {
        employeeDao.delete(id);
    }

    @Override
    public EmployeeDto getEmployeeByid(Long id)  {
        EmployeeDto employeeDto=modelMapper.map(employeeDao.getEmployeeById(id),EmployeeDto.class);
        return employeeDto;
    }

}
